package com.jiayuan.jr.elshell

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.jiayuan.jr.kiteshell.Ui.Fragment.MineFragment
import com.jiayuan.jr.kiteshell.Ui.Fragment.OtherFragment
import com.jiayuan.jr.viewmodule.fargment.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragments:List<Fragment>
    lateinit var selectIcon : IntArray
    private lateinit var normalIcon: IntArray
    lateinit var tabText: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragments = arrayListOf(HomeFragment(), OtherFragment(), MineFragment())
        tabText= arrayOf("首页","其他","我的")
        normalIcon=intArrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
        selectIcon= intArrayOf(R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
        navigationBar.titleItems(tabText)
                     .normalIconItems(normalIcon)
                     .selectIconItems(selectIcon)
                     .fragmentList(fragments)
                     .fragmentManager(supportFragmentManager)
                     .build()
        navigationBar.setMsgPointCount(2,109)
        navigationBar.onTabClickListener { _: View, position: Int ->
            when(position){
//                2 ->{
//                    ARouter.getInstance().build("/kite_module/bubble_activity").navigation()
//                    return@onTabClickListener true}
//                1->{ ARouter.getInstance().build("/kotlinmvp_module/read_bubble_activity").navigation()
//                    return@onTabClickListener true}
                 2 ->{
                     ARouter.getInstance().build("/kite_module/flutter_activity").navigation()
                     return@onTabClickListener true}
            }
            return@onTabClickListener false
        }
    }
}
