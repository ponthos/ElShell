package com.jiayuan.jr.kotlinmvpmodule.mvp.contract

import com.jess.arms.base.DefaultAdapter
import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import com.jiayuan.jr.modelmodule.ResponseModel.ArticResponse
import io.reactivex.Observable

class ReadBubbleContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View : IView {
        fun setAdapter(adapter: DefaultAdapter<*>)
        fun startLoadMore()
        fun endLoadMore()
        fun setArticles(articleResponses: List<ArticResponse>)
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model : IModel {
        fun getArticle(userid: Int): Observable<List<ArticResponse>>
    }
}
