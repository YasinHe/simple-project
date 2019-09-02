package com.company.pjname.api

import com.company.pjname.bean.User

/**
 * Created by HeYingXin on 2019/6/17.
 */
interface ApiService{

    //登录
    suspend fun login(userName: String,password :String): User?

}