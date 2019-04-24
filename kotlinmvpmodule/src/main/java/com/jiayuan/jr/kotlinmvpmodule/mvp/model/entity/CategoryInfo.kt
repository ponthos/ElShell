package com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/21
 * Description :
 */
data class CategoryInfo(
        val categoryName: String,//分类名
        val categoryCode: String//分类索引  可以在category中拿到对应的信息
)