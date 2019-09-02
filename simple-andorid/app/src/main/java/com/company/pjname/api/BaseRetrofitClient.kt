package com.company.pjname.api

import com.company.pjname.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by HeYingXin on 2019/6/17.
 */
abstract class BaseRetrofitClient {

    companion object {
        private const val TIME_OUT_CONNECT = 5
        private const val TIME_OUT_READ = 20
    }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }

            builder.addInterceptor(logging)
                    .connectTimeout(TIME_OUT_CONNECT.toLong(), TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT_READ.toLong(), TimeUnit.SECONDS)

            handleBuilder(builder)

            return builder.build()
        }

    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)

    fun <S> getService(serviceClass: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .baseUrl(baseUrl)
                .build().create(serviceClass)
    }
}
