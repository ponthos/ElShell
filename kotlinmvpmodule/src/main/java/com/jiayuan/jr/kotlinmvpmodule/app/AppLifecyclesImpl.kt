/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiayuan.jr.kotlinmvpmodule.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

import com.jess.arms.base.delegate.AppLifecycles

import butterknife.ButterKnife
import com.tencent.bugly.crashreport.CrashReport
import com.jiayuan.jr.kotlinmvpmodule.BuildConfig
import timber.log.Timber

/**
 * ================================================
 * 展示 [AppLifecycles] 的用法
 *
 *
 * Created by JessYan on 04/09/2017 17:12
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
class AppLifecyclesImpl : AppLifecycles {

    override fun attachBaseContext(base: Context) {
        MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化

    }

    override fun onCreate(application: Application) {
        Preference.init(application)



        CrashReport.initCrashReport(application, "812e582b4e", false);
        if (BuildConfig.LOG_DEBUG) {//Timber初始化
            //Timber 是一个日志框架容器,外部使用统一的Api,内部可以动态的切换成任何日志框架(打印策略)进行日志打印
            //并且支持添加多个日志框架(打印策略),做到外部调用一次 Api,内部却可以做到同时使用多个策略
            //比如添加三个策略,一个打印日志,一个将日志保存本地,一个将日志上传服务器
            Timber.plant(Timber.DebugTree())
            // 如果你想将框架切换为 Logger 来打印日志,请使用下面的代码,如想切换为其他日志框架请根据下面的方式扩展
            //                    Logger.addLogAdapter(new AndroidLogAdapter());
            //                    Timber.plant(new Timber.DebugTree() {
            //                        @Override
            //                        protected void log(int priority, String tag, String message, Throwable t) {
            //                            Logger.log(priority, tag, message, t);
            //                        }
            //                    });
            ButterKnife.setDebug(true)
        }





    }

    override fun onTerminate(application: Application) {

    }
}
