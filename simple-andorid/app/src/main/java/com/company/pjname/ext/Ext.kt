package com.company.pjname.ext

import android.content.Context
import android.graphics.Bitmap
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dovar.dtoast.DToast
import com.dovar.dtoast.inner.IToast
import com.company.pjname.App
import com.company.pjname.base.BaseFragment
import java.io.ByteArrayOutputStream


/**
 * Created by HeYingXin
 * on 2018/3/15 21:53
 */
fun View.dp2px(dp: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun View.px2dp(px: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

/**
 * 提示类
 */
var showToast: IToast? = null

fun Context.toast(@StringRes id: Int) {
    toast(getString(id))
}

fun toast(content: String) {
    UI {
        showToast?.apply {
            setText(com.company.pjname.R.id.tv_content_default, content)
            show()
        } ?: run {
            DToast.make(App.CONTEXT)
                    .setText(com.company.pjname.R.id.tv_content_default, content)
                    .setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 30)
                    .apply {
                        showToast = this
                    }.show()
        }
    }
}

/**
 * 日志类
 */
fun println(content: String) {
    com.company.pjname.util.L.e(content)
}

/**
 * 影藏键盘
 */
fun View.hideKeyBoard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 *显示键盘
 */
fun EditText.showKeyBoard(){
    this.postDelayed({
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    },300)

}

/**
 * 碎片跳转
 */
fun startToFragment(manager: FragmentManager, container: Int, newFragment: BaseFragment,isTop:Boolean = false) {
    val transaction = manager.beginTransaction()
    val fgs = manager.fragments
    if(fgs!=null&&fgs.size>0) {
        transaction.hide(fgs[fgs.size-1])
    }
    transaction.addToBackStack(newFragment::class.java.name)
    transaction.add(container, newFragment,newFragment::class.java.name)
    transaction.commit()
}

fun loadGlideBitmap(bitmap: Bitmap,imageView: ImageView){
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
    val bytes=baos.toByteArray()
    Glide.with(imageView.context).load(bytes).into(imageView)
}