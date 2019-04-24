package com.jiayuan.jr.kotlinmvpmodule.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jiayuan.jr.kotlinmvpmodule.app.Preference
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.SplashContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.SplashImageInfo
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.service.CommonService
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import javax.inject.Inject

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :
 */
@ActivityScope
class SplashModel @Inject
constructor(repositoryManager: IRepositoryManager)
    : BaseModel(repositoryManager),SplashContract.Model {


    override fun loadSplashImage(): Observable<SplashImageInfo> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java).getSplashImage()


    }

}