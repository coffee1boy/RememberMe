package com.zhm.model_news.activtiy.livedata

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayMap
import com.zhm.model_news.BR


/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/5  17:39
 *用途
 ************************************
 */
class User(firstName:String,lastName:String):BaseObservable() {
    var mFirstName=firstName
    var mLastName=lastName
    var isShow:Boolean=false
    var map = ObservableArrayMap<String, String>()
    init {
        map.put("aaa","asdf");
        map.put("vd","sdf");
        map.put("dfga","fg");
    }
    @Bindable
    fun getFirstName(): String {
        return mFirstName
    }
    fun setFirstName(name:String): Unit {
        mFirstName=name
//        notifyPropertyChanged()此处需要绑定BR文件
    }
    @Bindable
    fun getLastName(): String {
        return mLastName
    }
    fun setLastName(name:String): Unit {
        mLastName=name
    }

}