package com.zhm.model_news.activtiy.livedata.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhm.lib_common.core.NavigationConstants
import com.zhm.model_news.R
import com.zhm.model_news.activtiy.livedata.MediaCompement

/**
 * Activity继承AppCompatActivity即FragmentActivity的情况下
 * 怎么使用lifecycle
 * */
@Route(path = "${NavigationConstants.LIVEDATAACTIVITY}")
class LiveDataActivity : AppCompatActivity() {
    private val TAG=javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
//        lifecycle.addObserver(GenericLifecycleObserver{source, event ->
//            Log.d(TAG,"OnStateChange:event="+event)
//        })
        MediaCompement(this)
    }
}
