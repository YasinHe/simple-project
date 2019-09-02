package com.company.pjname.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by HeYingXin on 2019/9/2.
 */
@Parcelize
open class BaseRequestModel (var codeInfo:Int,var messageInfo:String) : Parcelable {
    override fun toString(): String {
        return "BaseRequestModel(code=$codeInfo, message='$messageInfo')"
    }
}