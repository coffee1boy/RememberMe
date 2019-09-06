package com.zhm.model_main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zhm.lib_common.basemvvm.helper.network.NetWorkManager
import com.zhm.lib_common.basemvvm.helper.network.request.NewsRequest
import com.zhm.lib_common.core.RetrofitConstants
import com.zhm.lib_common.uitls.ApplicationUtil
import com.zhm.lib_common.uitls.NavigationUtils
import com.zhm.model_main.BuildConfig
import com.zhm.model_main.R
import kotlinx.android.synthetic.main.activity_model_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class ModelMainActivity : AppCompatActivity() {
    private val tag=javaClass.simpleName
    var requestLauch:Job?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_main)
        NavigationUtils.init(isDebug(),application)
        ApplicationUtil.mApplication=application
    }

    override fun onResume() {
        super.onResume()
        jump_livedatab_btn.setOnClickListener {
            NavigationUtils.goLiveDataBActivity()
        }
        jump_livedata_btn.setOnClickListener {
            NavigationUtils.goLiveDataActivity()
        }
        jump_news_btn.setOnClickListener {
            NavigationUtils.goLoginActivity()
        }
        req_news_btn.setOnClickListener {
            requestNewsList()
        }
    }

    fun initModel(): Unit {
//        val model=ViewModelProvider.
    }
    fun requestNewsList(): Unit {
        requestLauch= GlobalScope.launch {
            try {
                val databean=async {
                    val newsRequest=NetWorkManager.create(NewsRequest::class.java)
                    newsRequest.getGank(RetrofitConstants.SUSPEND_NEWSREQUEST_URL).results
                }
                databean.await().let {
                        Log.e(tag,"getGankListmy"+ it[1].url)
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requestLauch?.cancel()
    }


    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}
