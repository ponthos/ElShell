package com.jiayuan.jr.kotlinmvpmodule.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.jiayuan.jr.kotlinmvpmodule.di.module.SignUpModule
import com.jiayuan.jr.kotlinmvpmodule.di.module.SplashModule
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.SplashActivity
import dagger.Component

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :启动页面的
 */
@ActivityScope
@Component(modules = [SplashModule::class],dependencies = [AppComponent::class])
interface SplashComponent {
    fun inject(activity:SplashActivity)
}