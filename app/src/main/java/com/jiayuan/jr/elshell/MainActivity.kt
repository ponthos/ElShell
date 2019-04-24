package com.jiayuan.jr.elshell

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { v->
            // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
            //                    ARouter.getInstance().build("/test/activity").navigation();
            ARouter.getInstance().build("/kite_module/bessel_activity").navigation()
            //                    // 2. 跳转并携带参数
            //                    ARouter.getInstance().build("/test/1")
            //                            .withLong("key1", 666L)
            //                            .withString("key3", "888")
            //                            .withObject("key4", new Test("Jack", "Rose"))
            //                            .navig
        }
    }
}
