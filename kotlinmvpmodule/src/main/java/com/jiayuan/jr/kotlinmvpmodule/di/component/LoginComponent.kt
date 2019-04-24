package com.jiayuan.jr.kotlinmvpmodule.di.component

//import com.jiayuan.jr.kotlinmvpmodule.di.module.MainModule

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.jiayuan.jr.kotlinmvpmodule.di.module.LoginModule
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.LoginActivity
import dagger.Component
//import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.MainActivity

@ActivityScope
@Component(modules = [LoginModule::class], dependencies = [AppComponent::class])
interface LoginComponent {
    fun inject(activity: LoginActivity)
}