package com.jiayuan.jr.kiteshell.Ui.Fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jiayuan.jr.viewmodule.R
import com.tencent.rtmp.TXLivePushConfig
import com.tencent.rtmp.TXLivePusher



class MineFragment : BaseFragment<IPresenter>() {
    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        val mLivePusher = TXLivePusher(activity!!)
        val mLivePushConfig = TXLivePushConfig()
        mLivePusher.config = mLivePushConfig

        val rtmpUrl = "rtmp://39.97.161.249:1935/hls/test"
        mLivePusher.startPusher(rtmpUrl)
        mLivePusher.startScreenCapture()

        //设置视频水印
        mLivePushConfig.setWatermark(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background), 10, 10);
        mLivePusher.setConfig(mLivePushConfig);
    }
//    fun triggerPrivateMode() {
//        if (mInPrivacy) {
//            Toast.makeText(activity, “隐私模式已开启”, Toast.LENGTH_SHORT).show()
//            mTVPrivateMode.setText(getString(R.string.private_mode_off))
//            mTVPrivateMode.setCompoundDrawables(mDrawableLockOn,null,null,null)
//            mPrivateBtn.setImageResource(R.mipmap.lock_off);
//            mTXLivePusher.pausePusher();
//        } else {
//            Toast.makeText(activity, “隐私模式已关闭”, Toast.LENGTH_SHORT).show()
//            mTXLivePusher.resumePusher()
//            mPrivateBtn.setImageResource(R.mipmap.lock_on)
//            mTVPrivateMode.setText(getString(R.string.private_mode_on))
//            mTVPrivateMode.setCompoundDrawables(mDrawableLockOff,null,null,null)
//        }
//        mInPrivacy = !mInPrivacy666666666777
//    }
    override fun setData(data: Any?) {

    }
}
