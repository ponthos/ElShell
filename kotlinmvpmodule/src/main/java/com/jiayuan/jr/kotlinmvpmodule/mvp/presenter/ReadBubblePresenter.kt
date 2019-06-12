package com.jiayuan.jr.kotlinmvpmodule.mvp.presenter

import android.app.Application
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.ReadBubbleContract
import com.jiayuan.jr.modelmodule.ResponseModel.ArticResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import me.jessyan.rxerrorhandler.handler.RetryWithDelay
import javax.inject.Inject


/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->Activity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */


@ActivityScope
class ReadBubblePresenter @Inject
constructor(
    model: ReadBubbleContract.Model,
    rootView: ReadBubbleContract.View,
    private var mErrorHandler: RxErrorHandler?,
    private var mApplication: Application?,
    private var mImageLoader: ImageLoader?,
    private var mAppManager: AppManager?
) : BasePresenter<ReadBubbleContract.Model, ReadBubbleContract.View>(model, rootView) {

    override fun onDestroy() {
        super.onDestroy()
        this.mErrorHandler = null
        this.mAppManager = null
        this.mImageLoader = null
        this.mApplication = null
    }

    fun getArticle(int: Int) {
        mModel.getArticle(int).subscribeOn(Schedulers.io())
            .retryWhen(RetryWithDelay(3, 2))
            .doOnSubscribe {}.subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            //                .doAfterTerminate(() -> {})
            //                .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(
                object : ErrorHandleSubscriber<List<ArticResponse>>(mErrorHandler!!) {
                    override fun onNext(articleResponses: List<ArticResponse>) {
                        mRootView.setArticles(articleResponses)
                    }
                    override fun onError(t: Throwable) {
                        super.onError(t)
                    }
                }
            )
    }
}
