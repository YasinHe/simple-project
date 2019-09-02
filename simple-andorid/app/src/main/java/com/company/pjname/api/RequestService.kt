package com.company.pjname.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by HeYingXin on 2019/6/17.
 */
interface RequestService {

    companion object {
        //测试请求地址+基础路由
        const val BASE_URL = "http://36.7.136.174:63080"//http://36.7.136.174:63080  http://hefei.win-sky.com.cn:62080
        const val ROUTE = "/app/auth/"

        //请求path
        const val LOGIN = "login"//登录


        //数据
        val gson: Gson = GsonBuilder().disableHtmlEscaping().create()
        var token:String = ""
    }

    @POST("$ROUTE{path}")
    fun post(@Path("path") path:String,@Body requestBody:RequestBody): Deferred<ResponseBody>

}