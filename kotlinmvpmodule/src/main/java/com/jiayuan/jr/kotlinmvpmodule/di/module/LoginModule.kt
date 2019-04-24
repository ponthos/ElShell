package com.jiayuan.jr.kotlinmvpmodule.di.module

import com.jess.arms.di.scope.ActivityScope
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.LoginContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.LoginModel
import dagger.Module
import dagger.Provides
//import com.jiayuan.jr.kotlinmvpmodule.mvp.model.MainModel
//import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.fragment.CategoryFragment
//import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.fragment.HomeFragment
//import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.fragment.MineFragment

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :
 */
@Module
class LoginModule
(private val view: LoginContract.View) {

    @ActivityScope
    @Provides
    internal fun provideLoginView(): LoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideLoginModel(model: LoginModel): LoginContract.Model {
        return model
    }
}

