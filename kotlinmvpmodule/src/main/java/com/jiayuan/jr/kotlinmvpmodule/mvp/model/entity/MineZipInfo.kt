package com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2019/1/5
 * Description :我的页面个人数据和收藏列表数据的整合
 */
data class MineZipInfo(val userInfo:UserInfo,val favorites:List<FavoriteInfo>)