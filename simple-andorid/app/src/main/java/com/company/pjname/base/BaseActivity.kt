package com.company.pjname.base

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.afollestad.materialdialogs.MaterialDialog
import com.eightbitlab.rxbus.Bus
import com.company.pjname.App
import com.company.pjname.R
import com.company.pjname.ui.splash.SplashActivity
import com.company.pjname.util.L
import com.readystatesoftware.systembartint.SystemBarTintManager
import java.util.*

/**
 * Created by HeYingXin
 * on 2018/1/9 14:01
 */
abstract class BaseActivity : AppCompatActivity() {

    private var mDialog: MaterialDialog? = null

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        checkSystem()
        initSystemBar()
        initView()
        initData()
        requestPermissions(99)
    }

    private fun checkSystem() {
        if (App.systemLive === 0 && this !is SplashActivity) {
            L.e("Tag","没资源了,重启")
            SplashActivity.start(this)
            finish()
        }
    }

    override fun onDestroy() {
        Bus.unregister(this)
        super.onDestroy()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    protected fun startActivity(z: Class<*>) {
        startActivity(Intent(this, z))
    }

    protected fun showProgressDialog(content: String) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                    .content(content).progress(true, 1)
                    .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(content)
        mDialog?.show()
    }

    protected fun showProgressDialog(resId: Int) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                    .content(getString(resId)).progress(true, 1)
                    .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(getString(resId))
        mDialog?.show()
    }

    protected fun dismissProgressDialog() {
        mDialog?.dismiss()
    }

    @SuppressLint("ObsoleteSdkInt")
    fun initSystemBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true)
            val mTintManager = SystemBarTintManager(this)
            mTintManager.isStatusBarTintEnabled = true
            mTintManager.setStatusBarTintResource(R.color.colorPrimary)
         }
    }

    @TargetApi(19)
    private fun setTranslucentStatus(on:Boolean) {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        if (on) {
            winParams.flags.or(bits)
        } else {
            winParams.flags.and(bits.inv())
        }
        win.attributes = winParams
    }


    // 请求权限
    fun requestPermissions(requestCode: Int) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                val requestPerssionArr = ArrayList<String>()
                val hasCamrea = checkSelfPermission(Manifest.permission.CAMERA)
                if (hasCamrea != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.CAMERA)
                }
                val hasSdcardRead = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                if (hasSdcardRead != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.READ_EXTERNAL_STORAGE)
                }

                val hasreadPhoneStatue = checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                if (hasreadPhoneStatue != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.READ_PHONE_STATE)
                }

                val hasSdcardWrite = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                if (hasSdcardWrite != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
                // 是否应该显示权限请求
                if (requestPerssionArr.size >= 1) {
                    val requestArray = arrayOfNulls<String>(requestPerssionArr.size)
                    for (i in requestArray.indices) {
                        requestArray[i] = requestPerssionArr[i]
                    }
                    requestPermissions(requestArray, requestCode)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        var flag = false
        for (i in permissions.indices) {
            if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                flag = true
            }
        }
        if (!flag) {
            requestPermissions(99)
        }
    }

}