package com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jiayuan.jr.kotlinmvpmodule.R
import com.jiayuan.jr.kotlinmvpmodule.app.Constant
import com.jiayuan.jr.kotlinmvpmodule.app.EnvelopeImageConfig
import com.jiayuan.jr.kotlinmvpmodule.app.loadImage
import com.jiayuan.jr.kotlinmvpmodule.di.component.DaggerSplashComponent
import com.jiayuan.jr.kotlinmvpmodule.di.module.SplashModule
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.SplashContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.presenter.SplashPresenter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description : 启动页面
 */
@Route(path = "/kotlinmvp_module/splash_activity")
class SplashActivity : EnvelopeBaseActivity<SplashPresenter>(), SplashContract.View {
    @Inject
    lateinit var mImageLoader: ImageLoader


    override fun showLoading() {


    }

    override fun launchActivity(intent: Intent) {
    }

    override fun getFragmentActivity(): FragmentActivity {
        return this
    }

    override fun hideLoading() {
    }

    override fun killMyself() {
        finish()
    }

    override fun showMessage(message: String) {
        Toasty.error(applicationContext, message).show()
    }

    override fun countDown(count: Long) {

    }

    override fun alreadyHavePermission() {
        //加载本地图片
        mIvSplash.loadImage(
                EnvelopeImageConfig.Builder()
                        .url(Constant.SPLASH_LOCAL_PATH + Constant.SPLASH_LOCAL_NAME)
                        .imageView(mIvSplash)
                        .cacheStrategy(1)
                        .errorPic(R.drawable.bg_default_splash)
                        .build())


    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .splashModule(SplashModule(this))
                .build()
                .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_splash
    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.getSplashImageInfo()
        mTvOneDay.show()
    }


}