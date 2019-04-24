package com.jiayuan.jr.kotlinmvpmodule.app

import com.jiayuan.jr.kotlinmvpmodule.di.component.DaggerEnvelopeComponent
import com.jiayuan.jr.kotlinmvpmodule.di.component.EnvelopeComponent
import com.jiayuan.jr.kotlinmvpmodule.di.module.EnvelopeModule
import com.jess.arms.base.BaseApplication
import com.jess.arms.utils.ArmsUtils

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

        EnvelopeComponent = DaggerEnvelopeComponent
                .builder()
                .appComponent(ArmsUtils.obtainAppComponentFromContext(this))
                .envelopeModule(EnvelopeModule())
                .build()
    }


    override fun EnvelopegComponent(): EnvelopeComponent {
        return EnvelopeComponent
    }
}