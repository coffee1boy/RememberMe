package com.zhm.model_news.activtiy.livedata.activity

import androidx.lifecycle.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhm.lib_common.core.NavigationConstants
import com.zhm.lib_coremodel.viewmodel.TestViewModel
import com.zhm.model_news.R
import com.zhm.model_news.activtiy.livedata.MediaCompement
import kotlinx.android.synthetic.main.activity_live_data_b.*

@Route(path = "${NavigationConstants.LIVEDATABACTIVITY}")
class LiveDataBActivity : AppCompatActivity() ,LifecycleOwner{
    private val TAG=javaClass.simpleName
    lateinit var mLifecycleRegistry: LifecycleRegistry
    lateinit var mTestViewModel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_b)
        mLifecycleRegistry=LifecycleRegistry(this)
        mLifecycleRegistry.markState(Lifecycle.State.CREATED)//标记当前activity状态
        lifecycle.addObserver(GenericLifecycleObserver{_, event ->
            Log.d(TAG,"OnStateChange1:event="+event)
        })
        MediaCompement(this)//此处关联Lifecycle
        setTextViewModel()
    }

    override fun onResume() {
        super.onResume()
        btn_set_textviewmodel.setOnClickListener {
            mTestViewModel.getNameEvent().setValue("6666666666666666666666")
        }
    }
    fun setTextViewModel(): Unit {//livecycle1.1.1中的livedata
        mTestViewModel=ViewModelProviders.of(this,TestViewModel.Factory("888888")).get(TestViewModel::class.java)
        val nameEvent=mTestViewModel.getNameEvent()
        nameEvent.observe(this, Observer<String> {
            Log.d(TAG,it)
            text_live_data_b.text=it+mTestViewModel.getStr()
        })
    }
    fun setTextViewModel2(): Unit {
//        mTestViewModel=ViewModelProvider(this)
    }
//    override fun onStart() {
//        super.onStart()
//        mLifecycleRegistry.markState(Lifecycle.State.STARTED)
//    }
    @NonNull
    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }
}
