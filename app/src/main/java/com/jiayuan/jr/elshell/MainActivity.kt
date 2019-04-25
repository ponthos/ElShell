package com.jiayuan.jr.elshell

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.jiayuan.jr.kiteshell.Ui.Fragment.MineFragment
import com.jiayuan.jr.kiteshell.Ui.Fragment.OtherFragment
import com.jiayuan.jr.viewmodule.fargment.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: Fragment
    private lateinit var otherFragment: Fragment
    private lateinit var mineFragment: Fragment
    private lateinit var fragment: Array<Fragment>
    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction
    private fun selectTab(i: Int) {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        hideAllFragment(fragmentTransaction)
        if (fragment[i].isAdded) {
            fragmentTransaction.show(fragment[i])
        } else {
            fragmentTransaction.add(R.id.fragment, fragment[i])
            fragmentTransaction.show(fragment[i])
        }
        fragmentTransaction.commit()
    }

    private fun hideAllFragment(fragmentTransaction: FragmentTransaction) {
        for (i in fragment.indices) {
            fragmentTransaction.hide(fragment[i])
        }
        //        fragmentTransaction.commit();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment()
        otherFragment = OtherFragment()
        mineFragment = MineFragment()
        fragment = arrayOf(homeFragment, otherFragment, mineFragment)
        selectTab(0)
        var mine = mine
        (if (mine != null) mine else throw KotlinNullPointerException()).setOnClickListener {
            // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
            //                    ARouter.getInstance().build("/test/activity").navigation();
            ARouter.getInstance().build("/kite_module/bessel_activity").navigation()
            //                    // 2. 跳转并携带参数
            //                    ARouter.getInstance().build("/test/1")
            //                            .withLong("key1", 666L)
            //                            .withString("key3", "888")
            //                            .withObject("key4", new Test("Jack", "Rose"))
            //                            .navigation();
        }
        (if (home != null) home else throw NullPointerException("Expression 'home' must not be null")).setOnClickListener {
            home.setOnClickListener { v->
                ARouter.getInstance().build("/kotlinmvp_module/read_bubble_activity").navigation()
            }
        }
        var other = other
        (if (other != null) other else throw KotlinNullPointerException()).setOnClickListener { ARouter.getInstance().build("/kite_module/bubble_activity").navigation() }
        other!!.setOnClickListener { ARouter.getInstance().build("/kotlinmvp_module/splash_activity").navigation() }
//        button.setOnClickListener { v->
//            // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//            //                    ARouter.getInstance().build("/test/activity").navigation();
//            ARouter.getInstance().build("/kite_module/bessel_activity").navigation()
//            //                    // 2. 跳转并携带参数
//            //                    ARouter.getInstance().build("/test/1")
//            //                            .withLong("key1", 666L)
//            //                            .withString("key3", "888")
//            //                            .withObject("key4", new Test("Jack", "Rose"))
//            //                            .navig
//        }
    }
}
