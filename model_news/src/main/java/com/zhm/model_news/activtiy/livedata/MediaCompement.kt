package com.zhm.model_news.activtiy.livedata

import androidx.lifecycle.GenericLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import android.util.Log

/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/5  10:10
 *用途
 * LifeCycle监听类，根据传进来的lifecycleowner可以监听主体的生命周期
 ************************************
 */
class MediaCompement(lifecycleOwner: LifecycleOwner) {
    private val TAG=javaClass.simpleName
    private val mLifecycleOwner: LifecycleOwner=lifecycleOwner
    init {
        mLifecycleOwner.lifecycle.addObserver(GenericLifecycleObserver{_, event ->
            when(event){
                Lifecycle.Event.ON_CREATE->onCreate()
                Lifecycle.Event.ON_START->onStart()
                Lifecycle.Event.ON_RESUME->onResume()
                Lifecycle.Event.ON_PAUSE->onPause()
                Lifecycle.Event.ON_STOP->onStop()
                Lifecycle.Event.ON_DESTROY->onDestroy()
                Lifecycle.Event.ON_ANY->onAny()
            }
        })
    }

    fun onCreate(): Unit {
        Log.d(TAG,"onCreate")
    }
    fun onStart(): Unit {
        Log.d(TAG,"onStart")
    }
    fun onResume(): Unit {
        Log.d(TAG,"onResume")
    }
    fun onPause(): Unit {
        Log.d(TAG,"onPause")
    }
    fun onStop(): Unit {
        Log.d(TAG,"onStop")
    }
    fun onDestroy(): Unit {
        Log.d(TAG,"onDestroy")
    }
    fun onAny(): Unit {

    }
}