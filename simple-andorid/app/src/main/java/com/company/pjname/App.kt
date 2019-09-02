package com.company.pjname

import android.app.Activity
import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary
import me.jessyan.autosize.AutoSize
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.onAdaptListener
import me.jessyan.autosize.unit.Subunits
import me.jessyan.autosize.utils.LogUtils
import java.util.*
import kotlin.properties.Delegates
import kotlin.system.exitProcess

/**
 * Created by HeYingXin
 * on 2018/3/13 13:35
 */
class App : Application() {

    companion object {
        lateinit var instance: App
        var systemLive: Int = 0
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        systemLive = 0
        CONTEXT = applicationContext
        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)
        AutoSize.initCompatMultiProcess(this)
        AutoSizeConfig.getInstance()
                .setBaseOnWidth(true)
                .setCustomFragment(true)
                .setUseDeviceSize(false)
                .onAdaptListener = object : onAdaptListener {
            override fun onAdaptBefore(target: Any, activity: Activity) {
                LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptBefore!", target.javaClass.name))
            }

            override fun onAdaptAfter(target: Any, activity: Activity) {
                LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptAfter!", target.javaClass.name))
            }
        }
        AutoSizeConfig.getInstance().unitsManager
                .setSupportDP(false)
                .setSupportSP(false)
                .supportSubunits = Subunits.MM
        customAdaptForExternal()
    }

    private fun customAdaptForExternal() {
//        AutoSizeConfig.getInstance().externalAdaptManager
//                .addExternalAdaptInfoOfActivity(DefaultErrorActivity::class.java!!, ExternalAdaptInfo(true, 400f))
    }

    fun logoutApp() {
        //
        eistApp()
    }

    fun eistApp() {
        exitProcess(0)
    }
}