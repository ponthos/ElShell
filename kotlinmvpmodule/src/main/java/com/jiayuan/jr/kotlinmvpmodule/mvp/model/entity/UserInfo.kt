package com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity

import cn.bmob.v3.BmobUser

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/23
 * Description :用户信息
 */
class UserInfo : BmobUser() {
    //昵称
    val nickname: String = "小眼"
    val userPortrait: String = "http://bmob-cdn-19399.b0.upaiyun.com/2018/05/23/4cb77ae840c8f9108028c2edf75cc350.png"//头像
    //默认分组的id
    var defaultFavoriteId = ""
}