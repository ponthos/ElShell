package com.jiayuan.jr.viewmodule.fargment.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jiayuan.jr.bannermodule.BannerConfig
import com.jiayuan.jr.bannermodule.Transformer
import com.jiayuan.jr.kotlinmvpmodule.app.Constant
import com.jiayuan.jr.viewmodule.R
import com.tencent.rtmp.TXLivePushConfig
import com.tencent.rtmp.TXLivePusher
import connectmodule.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
class HomeFragment : BaseFragment<IPresenter>() {
//    @BindView(R.id.banner)
//    internal var banner: Banner? = null
    internal var images: MutableList<String> = ArrayList()
    internal var titles: MutableList<String> = ArrayList()
    //如果你需要考虑更好的体验，可以这么操作
    override fun onStart() {
        super.onStart()
        //开始轮播
        banner!!.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        //结束轮播
        banner!!.stopAutoPlay()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        titles.add("网络图片一")
        titles.add("网络图片二")
        titles.add("网络图片三")
        images.add(Constant.pic_1)
        images.add(Constant.pic_2)
        images.add(Constant.pic_3)
        //设置banner样式
        banner!!.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        //设置图片加载器
        banner!!.setImageLoader(GlideImageLoader())
        //设置图片集合
        banner!!.setImages(images)
        //设置banner动画效果
        banner!!.setBannerAnimation(Transformer.DepthPage)
        //设置标题集合（当banner样式有显示title时）
        banner!!.setBannerTitles(titles)
        //设置自动轮播，默认为true
        banner!!.isAutoPlay(true)
        //设置轮播时间
        banner!!.setDelayTime(1500)
        //设置指示器位置（当banner模式中有指示器时）
        banner!!.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        banner!!.start()


        val mLivePushConfig = TXLivePushConfig()
        val mLivePusher = TXLivePusher(activity)

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
    }

    override fun setData(data: Any?) {

    }
}
