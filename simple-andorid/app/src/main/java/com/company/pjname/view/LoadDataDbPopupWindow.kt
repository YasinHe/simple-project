package com.company.pjname.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import com.company.pjname.R
import razerdp.basepopup.BasePopupWindow


/**
 * Created by HeYingXin on 2019/7/6.
 * //.setBackgroundColor(0) 无背景
 */
class LoadDataDbPopupWindow(context: Context?) : BasePopupWindow(context) {

    private lateinit var rcy_data: RecyclerView
    private lateinit var tv_search:TextView
    private lateinit var et_dim:EditText

    override fun onCreateContentView(): View {
        return createPopupById(R.layout.popup_load_data)
    }

    override fun onCreateShowAnimation(): Animation {
        return AnimationUtils.loadAnimation(context,R.anim.popup_in)
    }

    override fun onCreateDismissAnimation(): Animation {
        return AnimationUtils.loadAnimation(context,R.anim.popup_out)
    }

    /**
     * @param type 0:派警单位  1：民警  2：处置结果  3：处置地区
     */
    fun show(type:Int,linstener:ReturnDimStrLinstener) {
        tv_search = findViewById(R.id.tv_search)
        et_dim = findViewById(R.id.et_dim)
        tv_search.setOnClickListener{
            linstener.currentDim(et_dim.text.toString())
        }
        super.showPopupWindow()
    }

    fun getRecyclview():RecyclerView {
            rcy_data = findViewById(R.id.rcy_data)
            rcy_data.isNestedScrollingEnabled = false
            rcy_data.run {
                layoutManager = LinearLayoutManager(this.context)

            }
            return rcy_data
    }

    public interface ReturnDimStrLinstener{
        fun currentDim(dim:String)
    }
}