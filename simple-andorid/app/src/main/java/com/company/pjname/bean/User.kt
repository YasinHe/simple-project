package com.company.pjname.bean

/**
 * Created by HeYingXin on 2019/9/2.
 */
data class User(
        val `data`: Data,
        val code: Int,
        val message: String
) : BaseRequestModel(code, message) {

    data class Data(
            val companyId: Int,
            val companyName: String,
            val createTime: Long,
            val createUserId: Any,
            val id: Int,
            val mobile: String,
            val name: String,
            val roles: Any,
            val status: Int,
            val token: String,
            val updateTime: Long,
            val updateUserId: Any,
            val userType: String,
            val userTypeName: String,
            val username: String
    )
}