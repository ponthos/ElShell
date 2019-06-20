package com.jiayuan.jr.elshell

import com.alibaba.android.arouter.launcher.ARouter
import com.jess.arms.base.BaseApplication
import com.jess.arms.utils.ArmsUtils
import com.jiayuan.jr.kotlinmvpmodule.app.Envelope
import com.jiayuan.jr.kotlinmvpmodule.di.component.DaggerEnvelopeComponent
import com.jiayuan.jr.kotlinmvpmodule.di.component.EnvelopeComponent
import com.jiayuan.jr.kotlinmvpmodule.di.module.EnvelopeModule
import com.tencent.rtmp.TXLiveBase



/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/11/23
 * Description :
 */
class EnvelopeApplication : BaseApplication(), Envelope {

    private lateinit var EnvelopeComponent: EnvelopeComponent
    override fun onCreate() {
        super.onCreate()
        //直播SDK
        val licenceURL = "http://license.vod2.myqcloud.com/license/v1/f4bca43b6cef21ce70cb41a169fcffee/TXLiveSDK.licence" // 获取到的 licence url
        val licenceKey = "ea4fc69df026dcfb52dcf7d9a9bc1374" // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)

        EnvelopeComponent = DaggerEnvelopeComponent
                .builder()
                .appComponent(ArmsUtils.obtainAppComponentFromContext(this))
                .envelopeModule(EnvelopeModule())
                .build()

//        if (Api.Debug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }


    override fun EnvelopegComponent(): EnvelopeComponent {
        return EnvelopeComponent
    }
}