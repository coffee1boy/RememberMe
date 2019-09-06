package com.zhm.lib_common.uitls

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.zhm.lib_common.core.NavigationConstants

/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/3  15:45
 *用途
 ************************************
 */
object NavigationUtils {
    fun init(isDebug:Boolean,application:Application){
        if (isDebug){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(application)
    }
    fun goLiveDataActivity(){
        ARouter.getInstance().build(NavigationConstants.LIVEDATAACTIVITY).navigation()
    }
    fun goLiveDataBActivity(){
        ARouter.getInstance().build(NavigationConstants.LIVEDATABACTIVITY).navigation()
    }
    fun  goLoginActivity(){
        ARouter.getInstance().build(NavigationConstants.NEWSONEACTIVITY).navigation()
    }
}