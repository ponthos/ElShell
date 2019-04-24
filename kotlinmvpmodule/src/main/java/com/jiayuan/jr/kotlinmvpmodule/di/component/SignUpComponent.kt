package com.jiayuan.jr.kotlinmvpmodule.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.jiayuan.jr.kotlinmvpmodule.di.module.SignUpModule
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.SignUpActivity
import dagger.Component

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :注册
 */
@ActivityScope
@Component(modules = [SignUpModule::class], dependencies = [AppComponent::class])
interface SignUpComponent {
    fun inject(activity: SignUpActivity)
}