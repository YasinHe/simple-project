package com.company.pjname.base

import android.os.Bundle
import android.view.View

/**
 * Created by HeYingXin on 2019/6/27.
 * 第一次fragment显示，进行懒加载(FragmentPagerAdapter)
 */
abstract class LazyFragment:BaseFragment() {

    private var isViewCreated: Boolean = false//视图是否已经创建
    private var isUiVisible: Boolean = false//该fragment是否对用户可见

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isViewCreated = true
        isDoLazyLoad()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isUiVisible = true
            isDoLazyLoad()
        }else{
            isUiVisible = false
        }
    }

    /**
     * 是否可以做延迟加载
     */
    private fun isDoLazyLoad() {
        if (isViewCreated && isUiVisible) {
            lazyLoad()
            isViewCreated = false
            isUiVisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreated = false
        isUiVisible = false
    }

    /**
     * 延迟加载
     */
    protected abstract fun lazyLoad()
}