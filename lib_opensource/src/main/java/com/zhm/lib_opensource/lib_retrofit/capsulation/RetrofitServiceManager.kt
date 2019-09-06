package com.zhm.lib_opensource.lib_retrofit.capsulation

import android.util.Log
import com.zhm.lib_opensource.lib_retrofit.capsulation.HttpCommonInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 ************************************
 *@Author revolve
 *创建时间：2019/8/28  16:25
 *用途
 ************************************
 */
class RetrofitServiceManager(base_url:String,default_time_out:Long=5,default_read_time_out:Long=10) {
    private val DEFAULT_TIME_OUT=default_time_out
    val DEFAULT_READ_TIME_OUT=default_read_time_out
    val BASE_URL:String=base_url
    lateinit var mRetrofit:Retrofit
    init {
        initialize()
    }
    fun initialize(){
        //create a OKhttpClient
        var builder= OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//Connection TimeOut
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//Writeting TimeOut
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//Reading TimeOut
        //Add Common Parameter Interceptor
        val commonInterceptor= HttpCommonInterceptor.Builder()
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
            .baseUrl(BASE_URL)
            .build()
    }
    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
    </T> */
    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }
    companion object {
        val tag=javaClass.simpleName
        var base_url:String=""
        private var instance: RetrofitServiceManager? = null
            get() {
                if (field == null) {
                    Log.e(tag,"new:"+ base_url)
                    field = RetrofitServiceManager(base_url)
                }
                return field
            }
        @Synchronized
        fun get(): RetrofitServiceManager{
            return instance!!
        }
    }


}