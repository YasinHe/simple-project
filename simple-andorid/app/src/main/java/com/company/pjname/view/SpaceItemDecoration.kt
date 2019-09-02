package com.company.pjname.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by HeYingXin
 * on 2018/3/15 21:45
 */
class SpaceItemDecoration(space: Int) : RecyclerView.ItemDecoration() {

    private val mSpace = space


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect?.top = 0
        outRect?.bottom = mSpace
    }
}