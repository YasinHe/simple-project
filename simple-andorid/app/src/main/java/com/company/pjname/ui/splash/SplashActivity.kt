package com.company.pjname.ui.splash

import android.content.Context
import android.content.Intent
import com.company.pjname.App
import com.company.pjname.R
import com.company.pjname.base.BaseActivity
import com.company.pjname.ext.toast
import com.company.pjname.util.Preference

/**
 * Created by HeYingXin
 * on 2018/4/5 07:56
 */
class SplashActivity : BaseActivity(), SplashContract.View {

    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var token = ""

    companion object {
        fun start(mContext:Context){
            val intent = Intent(mContext,SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            mContext.startActivity(intent)
        }
    }

    override var mPresenter: SplashContract.Presenter = SplashPresenter(this)

    override fun getLayoutResId() = R.layout.activity_login

    override fun initView() {
        App.systemLive = -1
    }

    override fun initData() {
        mPresenter.connect()
    }

    override fun connectSucc() {
    }

    override fun connectFail(message: String) {
        dismissProgressDialog()
        toast(message)
    }
}