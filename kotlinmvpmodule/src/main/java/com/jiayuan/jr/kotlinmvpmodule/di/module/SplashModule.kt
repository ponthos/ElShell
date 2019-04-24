package com.jiayuan.jr.kotlinmvpmodule.di.module

import com.jess.arms.di.scope.ActivityScope
import com.tbruyelle.rxpermissions2.RxPermissions
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.SplashContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.SplashModel
import dagger.Module
import dagger.Provides

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :启动
 */
@Module
class SplashModule(val view: SplashContract.View) {
    @ActivityScope
    @Provides
    internal fun provideSplashView(): SplashContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideSplashModel(model: SplashModel): SplashContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideRxPermission() = RxPermissions(view.getFragmentActivity())

}