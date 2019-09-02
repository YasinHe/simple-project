package com.company.pjname.ui.splash

import com.company.pjname.api.HttpController
import com.company.pjname.api.RequestService
import com.company.pjname.ext.executeRequest
import kotlinx.coroutines.Job

/**
 * Created by HeYingXin
 * on 2018/4/5 08:13
 */
class SplashPresenter(private val mView: SplashContract.View) : SplashContract.Presenter{

    lateinit var job: Job

    init {
        mView.mPresenter = this
    }

    override fun end() {
        if (::job.isInitialized) job.cancel()
    }

    override fun connect() {
        job = executeRequest(
                request = {
                    HttpController.instance.login("1000000000","hyx")
                },
                onSuccess = {
                    RequestService.token = it.data.token
                    mView.connectSucc()
                },
                onFail = {
                    it.printStackTrace()
                    mView.connectFail(it.message.toString())
                }
        )
    }
}