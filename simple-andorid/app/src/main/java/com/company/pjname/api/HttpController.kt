package com.company.pjname.api

/**
 * Created by HeYingXin on 2019/6/18.
 */
class HttpController private constructor(){
    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder= ApiServiceImpl()
    }
}