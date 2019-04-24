package com.jiayuan.jr.kotlinmvpmodule.mvp.contract

import android.app.Activity
import android.support.v4.app.FragmentActivity
import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.SplashImageInfo
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.UserInfo
import io.reactivex.Observable

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :启动页信息
 */
interface SplashContract {
    interface View :IView{
        fun getFragmentActivity():FragmentActivity
        fun alreadyHavePermission()
        fun countDown(count:Long)
    }

    interface Model :IModel{
        /**
         * 根据日期判断当前的图片是不是最新的,
         * 读取始终是读取的本地的  (会默默的下载一张图片)
         */
        fun loadSplashImage():Observable<SplashImageInfo>
    }
}