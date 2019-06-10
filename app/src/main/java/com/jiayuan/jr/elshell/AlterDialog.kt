//package com.jiayuan.jr.elshell
//
//import android.content.Context
//import android.view.View
//
//interface AlterDialog {
//     var alterDialog: AlterDialog?
//        get() = null
//        set(value) = TODO()
//    fun getInstance(context: Context,resource: Int,rootViewID:Int,styleID:Int):AlterDialog{
//        return if(null==alterDialog){
//            RememberDialog(context).builder(resource,rootViewID,styleID)
//        }else{
//            this
//        }
//    }
//    fun getRootView(): View
//    fun builder(resource: Int,rootViewID:Int,styleID:Int):AlterDialog
//    fun onClick(id:Int,onClickListener: View.OnClickListener):AlterDialog
//    fun setText(id: Int,strId:Int)
//    fun setDrawable(id:Int, drawId:Int)
//    fun setVisibility(id: Int)
//    fun show()
//    fun cancel()
//    fun isShowing():Boolean
//    fun setCancelable(cancel:Boolean):AlterDialog
//}