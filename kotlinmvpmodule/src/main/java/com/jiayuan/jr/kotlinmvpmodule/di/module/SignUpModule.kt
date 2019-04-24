package com.jiayuan.jr.kotlinmvpmodule.di.module

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.di.scope.FragmentScope
//import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.MineContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.SignUpContract
//import com.jiayuan.jr.kotlinmvpmodule.mvp.model.MineModel
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.SignUpModel
import dagger.Module
import dagger.Provides

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :注册
 */
@Module
class SignUpModule(val view:SignUpContract.View) {
    @ActivityScope
    @Provides
    internal fun provideSignUpView(): SignUpContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideSignUpModel(model: SignUpModel): SignUpContract.Model {
        return model
    }
}