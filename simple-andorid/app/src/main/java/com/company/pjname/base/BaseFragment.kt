package com.company.pjname.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus

/**
 * Created by HeYingXin
 * on 2018/9/29 16:17
 */
abstract class BaseFragment : Fragment() {

    protected val delayTime = 100L

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        Bus.unregister(this)
        super.onDestroy()
    }

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    abstract fun initData()
}