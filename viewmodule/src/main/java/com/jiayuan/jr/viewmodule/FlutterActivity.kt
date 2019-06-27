package com.jiayuan.jr.viewmodule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.alibaba.android.arouter.facade.annotation.Route
import io.flutter.facade.Flutter

/**
 *@desc
 *@auth ${user}
 *time 2019-06-26 11:23
 */
@Suppress("DEPRECATION")
@Route(path = "/kite_module/flutter_activity")
class FlutterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewmodule_fragment_flutter)
        val flutterView = Flutter.createView(this@FlutterActivity,lifecycle,"route1")
        val layout = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        addContentView(flutterView, layout)
    }
}
