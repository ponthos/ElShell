package com.jiayuan.jr.elshell

import android.app.Activity
import android.os.Bundle
import com.tencent.rtmp.TXLivePushConfig
import com.tencent.rtmp.TXLivePusher
import kotlinx.android.synthetic.main.activity_camera.*


/**
 *@desc
 *@auth ${user}
 *time 2019-06-20 14:40
 */
class CameraPusherActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val mLivePushConfig = TXLivePushConfig()
        val mLivePusher = TXLivePusher(this)

        // 一般情况下不需要修改 config 的默认配置
        mLivePusher.config = mLivePushConfig

//        //启动本地摄像头预览
//        val mPusherView = findViewById<View>(R.id.pusher_tx_cloud_view) as TXCloudVideoView
        mLivePusher.startCameraPreview(pusher_tx_cloud_view)

        val rtmpURL = "rtmp://39.97.161.249:1935/hls/test" //此处填写您的 rtmp 推流地址
        val ret = mLivePusher.startPusher(rtmpURL.trim())
        if (ret == -5) {
//            Log.i(TAG, "startRTMPPush: license 校验失败")
        }
        fun stop(){
            mLivePusher.stopPusher();
            mLivePusher.stopCameraPreview(true); //如果已经启动了摄像头预览，请在结束推流时将其关闭。
        }
    }
}