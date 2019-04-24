package com.jiayuan.jr.kotlinmvpmodule.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import cn.bmob.v3.Bmob
import com.jaeger.library.StatusBarUtil
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.LoginActivity
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.SignUpActivity
import com.jiayuan.jr.kotlinmvpmodule.mvp.ui.activity.SplashActivity
import com.zhihu.matisse.ui.MatisseActivity
import org.jetbrains.anko.startActivity
import timber.log.Timber

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/22
 * Description :
 */
class ActivityLifecycleImpl : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {


    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {
        activity?.let {
            //30秒间隔  显示闪屏
            val showSplash = System.currentTimeMillis() - 30000 >= it.intent.getLongExtra("time", System.currentTimeMillis())
            if (it !is SplashActivity && showSplash) {
                it.startActivity<SplashActivity>("isFirst" to false)
            }
            it.intent.putExtra("time", Long.MAX_VALUE)

        }
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
        activity?.let {
            if (it == it.getTopActivity()) {
                it.intent.putExtra("time", System.currentTimeMillis())
            }
        }

    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        Timber.i("onActivityCreated")

        Bmob.initialize(activity, Constant.BMOB_APPLICATION_KEY)
        activity?.let {
            when (it) {
                is LoginActivity, is SignUpActivity -> {
                    StatusBarUtil.setTranslucent(it, 55)
                }
                is SplashActivity -> StatusBarUtil.setTranslucent(it)
//                is GalleryActivity, is ImageCollectionActivity -> {
//                    StatusBarUtil.setTranslucent(it, 55)
//                    StatusBarUtil.setLightMode(it)
//                }
                is MatisseActivity -> {

                }
                else -> {
                    StatusBarUtil.setLightMode(it)
                }
            }
        }

    }

}