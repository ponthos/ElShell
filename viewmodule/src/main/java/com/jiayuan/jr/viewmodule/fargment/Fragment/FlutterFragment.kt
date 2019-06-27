package com.jiayuan.jr.viewmodule.fargment.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jiayuan.jr.viewmodule.R
import io.flutter.facade.Flutter
import kotlinx.android.synthetic.main.viewmodule_fragment_flutter.*

/**
 *@desc
 *@auth ${user}
 *time 2019-06-25 17:55
 */
class MineFragment : BaseFragment<IPresenter>() {
    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun initData(savedInstanceState: Bundle?) {
        tv_go_flutter.setOnClickListener { _->
            getActivity()!!.getSupportFragmentManager().beginTransaction()
                .add(R.id.container, Flutter.createFragment("/"))
                .addToBackStack("flutter")
                .commit();
        }
    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.viewmodule_fragment_flutter, container, false)
    }

}