package com.zhm.lib_coremodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/5  11:37
 *用途
 * Livecycle1.1.1中的livedata使用
 * 添加了Factory携带参数
 ************************************
 */
class TestViewModel(str:String):ViewModel() {
    private val mNameEvent:MutableLiveData<String> = MutableLiveData()
    private val mStr=str

    fun getNameEvent(): MutableLiveData<String> {
        return mNameEvent
    }
    fun getStr(): String{
        return mStr
    }

    open class Factory(str:String):ViewModelProvider.Factory{
        private val mStr=str
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TestViewModel(mStr) as T
        }
    }
}