package com.zhm.lib_common.basemvvm.helper.network

import android.util.Log
import com.zhm.lib_common.core.RetrofitConstants
import com.zhm.lib_opensource.lib_retrofit.capsulation.HttpCommonInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/3  17:47
 *用途
 ************************************
 */
class NetWorkManager(default_time_out:Long=5,default_read_time_out:Long=10)  {
//    private var DEFAULT_TIME_OUT:Long
    val DEFAULT_TIME_OUT=default_time_out
    val DEFAULT_READ_TIME_OUT=default_read_time_out
    init {
        initialize()
    }

    fun initialize(){
//        create a  okhttpclient
        val builder=OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS)
            .readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS)
//        add common paramter Interceptor
        val  commonInterceptor=HttpCommonInterceptor.Builder()
            .addHeaderParams("paltform","android")
            .addHeaderParams("userToken","1234343434dfdfd3434")
            .addHeaderParams("userId","123445")
            .build()
        builder.addInterceptor(commonInterceptor)
        //create Retrofit
        mRetrofit= Retrofit.Builder()
            .client(builder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitConstants.SUSPEND_URL)
            .build()
    }
    companion object {
        val tag=javaClass.simpleName
        lateinit var mRetrofit: Retrofit
        private var instance: NetWorkManager? = null
            get() {
                if (field == null) {
                    Log.e(tag,"new:")
                    field = NetWorkManager()
                }
                return field
            }
        /**
         * 获取对应的Service
         * @param service Service 的 class
         * @param <T>
         * @return
        </T> */
        fun <T> create(service: Class<T>): T {
            if (!this::mRetrofit.isInitialized)get()
            return mRetrofit.create(service)
        }
        @Synchronized
        fun get(): NetWorkManager{
            return instance!!
        }
    }
}