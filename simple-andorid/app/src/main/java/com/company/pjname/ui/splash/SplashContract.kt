package com.company.pjname.ui.splash

import com.company.pjname.base.BasePresenter
import com.company.pjname.base.BaseView

/**
 * Created by HeYingXin
 * on 2018/4/5 07:57
 */
interface SplashContract {

    interface View : BaseView<Presenter> {
        fun connectSucc()
        fun connectFail(message: String)
    }

    interface Presenter : BasePresenter {
        fun connect()
    }
}