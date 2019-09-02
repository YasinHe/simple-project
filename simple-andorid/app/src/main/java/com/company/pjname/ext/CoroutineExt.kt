package com.company.pjname.ext

import com.company.pjname.util.L
import kotlinx.coroutines.*

/**
 * Created by HeYingXin
 * on 2019/1/24 16:03
 */
fun <T> executeRequest(request: suspend () -> T?,
                       onSuccess: (T) -> Unit = {},
                       onFail: (Throwable) -> Unit = {}): Job {
    val uiScope = CoroutineScope(Dispatchers.Main)
    return uiScope.launch {
        try {
            val res: T? = withContext(Dispatchers.IO) {
                request()
            }
            res?.let {
                onSuccess(it)
            }
        } catch (e: CancellationException) {
            L.e("executeRequest", "job cancelled")
        } catch (e: Exception) {
            L.e("executeRequest", "request caused exception")
            onFail(e)
        }
    }
}

fun UI(block: suspend CoroutineScope.() -> Unit) {
    CoroutineScope(Dispatchers.Main).launch { block() }
}

fun async(block : suspend () -> Unit){
    CoroutineScope(Dispatchers.IO).launch {
        block()
    }
}

/**
 * 使用示例
 * //        async(block = {
   //            val succ = HttpController.instance.connect()
   //            val query = HttpController.instance.queryWarning()
   //            val operate = HttpController.instance.operateNormalSignIn()
   //        },catchBlock = {
   //            println.e("async发现异常:"+it.message)
   //        })
 */
fun async(block : suspend () -> Unit , catchBlock: suspend CoroutineScope.(Throwable) -> Unit){
    CoroutineScope(Dispatchers.IO).launch {
        try {
            block()
        } catch(e: Throwable) {
            L.e("async发现异常:"+e.message)
            catchBlock(e)
        }
    }
}


