package com.company.pjname.view

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.company.pjname.R

/**
 * Created by HeYingXin
 * on 2018/3/21 22:14
 */
class CustomLoadMoreView : LoadMoreView() {
    override fun getLayoutId(): Int {
        return R.layout.view_load_more
    }

    override fun getLoadingViewId(): Int {
        return R.id.load_more_loading_view
    }

    override fun getLoadFailViewId(): Int {
        return R.id.load_more_load_fail_view
    }

    override fun getLoadEndViewId(): Int {
        return R.id.load_more_load_end_view
    }
}