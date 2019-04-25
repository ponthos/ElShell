package com.jiayuan.jr.kotlinmvpmodule.app

import android.support.v4.app.FragmentManager
import com.jiayuan.jr.kotlinmvpmodule.callback.onActivityBackCallback

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/26
 * Description :
 */
object FragmentBackHelper {
    fun HandleBack(fragmentManager: FragmentManager): Boolean {
        val fragments = fragmentManager.fragments
        fragments.forEach {
            if (it is onActivityBackCallback) {
                return it.onBackPressed()
            }
        }

        return false
    }
}