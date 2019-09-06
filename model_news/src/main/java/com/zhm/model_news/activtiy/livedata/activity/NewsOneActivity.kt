package com.zhm.model_news.activtiy.livedata.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhm.lib_common.core.NavigationConstants
import com.zhm.model_news.R

@Route(path = "${NavigationConstants.NEWSONEACTIVITY}")
class NewsOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_one)
    }
}
