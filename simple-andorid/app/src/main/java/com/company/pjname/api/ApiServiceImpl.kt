package com.company.pjname.api

import com.company.pjname.api.RequestService.Companion.LOGIN
import com.company.pjname.api.RequestService.Companion.gson
import com.company.pjname.api.RequestService.Companion.token
import com.company.pjname.bean.User
import com.company.pjname.util.AesEncryptUtils
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject


/**
 * 真实请求参数拼接，未能完全定下来之前，不考虑复用bean
 * Created by HeYingXin on 2019/6/17.
 */
class ApiServiceImpl : ApiService {

    override suspend fun login(userName: String,password :String): User? {
        val jsonObject = JSONObject()
        jsonObject.put("userName",userName)
        jsonObject.put("password",password)
        jsonObject.put("token", token)
        val requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                encrypt(jsonObject))
        val deal = RetrofitClient.service.post(LOGIN,requestBody).await()
        return dealTarget(deal)
    }

    /**
     * 请求加密前置
     */
    private inline fun encrypt(jsonObject:JSONObject):String{
        val requestJson = JSONObject()
        requestJson.put("requestBody", AesEncryptUtils.encrypt(jsonObject.toString(), "#wms.app&?xpo*+!"))
        return requestJson.toString()
    }

    /**
     * 请求解密后置(并统一把错误处理掉)
     */
    inline fun <reified T : Any> dealTarget(result: ResponseBody): T? {
        val data = JSONObject(result.string()).get("responseBody")
        val json = AesEncryptUtils.decode(data.toString(),"#wms.app&?xpo*+!")
        //判断请求结果是否正确
        val result = JSONObject(json)
        if(result.get("code")!=0){
            throw Exception(result.getString("message"))
        }
        return gson.fromJson(json, T::class.java) as T
    }
}