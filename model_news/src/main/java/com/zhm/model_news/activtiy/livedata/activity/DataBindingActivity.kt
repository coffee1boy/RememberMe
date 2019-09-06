package com.zhm.model_news.activtiy.livedata.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zhm.model_news.R
import com.zhm.model_news.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DataBindingUtil.setContentView<ActivityDataBindingBinding>(this,R.layout.activity_data_binding)
        setContentView(ActivityDataBindingBinding.inflate(layoutInflater,null,false).root)
    }
}
