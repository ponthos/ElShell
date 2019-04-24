package com.jiayuan.jr.kotlinmvpmodule.di.module

import android.app.Application
import com.jiayuan.jr.kotlinmvpmodule.di.scope.EnvelopeScope
import com.tencent.cos.xml.CosXmlServiceConfig
import com.tencent.cos.xml.CosXmlSimpleService
import com.tencent.qcloud.core.auth.ShortTimeCredentialProvider
import dagger.Module
import dagger.Provides

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/11/23
 * Description :
 */
@Suppress("DEPRECATION")
@Module
class EnvelopeModule {

    /**
     * 腾讯对象云服务
     */
    @EnvelopeScope
    @Provides
    fun provideCosXmlService(application: Application): CosXmlSimpleService {
        return CosXmlSimpleService(application, CosXmlServiceConfig.Builder()
                .setAppidAndRegion("1252246683", "ap-chengdu")
                .builder(), ShortTimeCredentialProvider("AKIDSWP89Vrrywz52xRQPHExaN5fAydKYaYZ",
                "56xlT3ZwJmLvMtMnGdq01t5BjDan1KZ9", 300))
    }
}