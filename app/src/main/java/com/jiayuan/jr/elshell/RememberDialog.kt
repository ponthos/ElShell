//package com.jiayuan.jr.elshell
//
//import android.app.Dialog
//import android.content.Context
//import android.support.constraint.ConstraintLayout
//import android.view.Display
//import android.view.LayoutInflater
//import android.view.View
//import android.widget.FrameLayout
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.TextView
//
//open class RememberDialog(context: Context) :AlterDialog{
//    lateinit var context:Context
//    lateinit var display: Display
//    lateinit var lLayout_bg: ConstraintLayout
//    lateinit var view:View
//    lateinit var dialog:Dialog
//    override fun getRootView(): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        return view
//    }
//    override fun builder(resource: Int,rootViewID:Int,styleID:Int): AlterDialog {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        view=LayoutInflater.from(context).inflate(resource,null)
//        lLayout_bg= with(view) { findViewById(rootViewID) }
//        dialog= Dialog(context,styleID)
//        dialog.setContentView(view)
//
//        lLayout_bg.layoutParams = FrameLayout.LayoutParams(display.width*0.85 as Int,LinearLayout.LayoutParams.WRAP_CONTENT)
//        return this
//    }
//
//    /**
//     * @author pans
//     * @param id
//     * @param onClickListener
//     * @return AlterDialog
//     * @since 1.0
//     */
//    override fun onClick(id: Int, onClickListener: View.OnClickListener): AlterDialog {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        view.findViewById<View>(id).setOnClickListener {
//            v ->{
//            if(null!=onClickListener){
//                onClickListener.onClick(v)
//                }
//                dialog.dismiss()
//            }
//        }
//    }
//
//    override fun setText(id: Int, strId: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        view.findViewById<TextView>(id).text = context.resources.getString(strId)
//    }
//
//    override fun setDrawable(id: Int, drawId: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        view.findViewById<ImageView>(id).drawable=context.resources.getDrawable(drawId)
//    }
//
//    override fun setVisibility(id: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        if(view.visibility == View.GONE){
//            view.findViewById<View>(id).visibility=View.VISIBLE
//        }else{
//            view.findViewById<View>(id).visibility=View.GONE
//        }
//    }
//
//    override fun show() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        if(null!=dialog&&!dialog.isShowing){
//            dialog.show()
//        }
//    }
//
//    override fun cancel() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        if(null!=dialog&&!dialog.isShowing){
//            dialog.dismiss()
//        }
//    }
//
//    override fun isShowing(): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        return dialog.isShowing;
//    }
//
//    override fun setCancelable(cancel: Boolean): AlterDialog {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        if(null!=dialog)
//            dialog.setCancelable(cancel)
//        return this
//    }
//
//}
