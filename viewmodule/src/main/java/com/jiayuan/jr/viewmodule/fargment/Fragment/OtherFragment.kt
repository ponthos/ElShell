package com.jiayuan.jr.kiteshell.Ui.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jiayuan.jr.viewmodule.R
import com.tencent.rtmp.TXLiveConstants
import com.tencent.rtmp.TXLivePlayer
import kotlinx.android.synthetic.main.fragment_other.*


class OtherFragment : BaseFragment<IPresenter>() {
    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }
    var mLivePlayer: TXLivePlayer? =null
    override fun initData(savedInstanceState: Bundle?) {
//        //mPlayerView 即 step1 中添加的界面 view
//        val mView = view.findViewById(R.id.video_view) as TXCloudVideoView

        //创建 player 对象
        mLivePlayer = TXLivePlayer(activity!!)

        //关键 player 对象与界面 view
        mLivePlayer!!.setPlayerView(video_view)

        val flvUrl = "rtmp://39.97.161.249:1935/hls/test"
        mLivePlayer!!.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_LIVE_RTMP) //推荐 FLV

        // 设置填充模式
        mLivePlayer!!.setRenderMode(TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION);
        // 设置画面渲染方向
        mLivePlayer!!.setRenderRotation(TXLiveConstants.RENDER_ROTATION_LANDSCAPE);
    }

    override fun setData(data: Any?) {
        // 暂停
        mLivePlayer!!.pause();
        // 继续
        mLivePlayer!!.resume();
    }

    override fun onDestroy() {
        super.onDestroy()
        mLivePlayer!!.stopPlay(true) // true 代表清除最后一帧画面
        video_view.onDestroy()
    }
}
