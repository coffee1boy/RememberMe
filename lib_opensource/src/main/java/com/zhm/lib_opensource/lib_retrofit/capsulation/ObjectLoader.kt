package com.zhm.lib_opensource.lib_retrofit.capsulation

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



/**
 ************************************
 *@Author revolve
 *创建时间：2019/8/28  17:15
 *用途
 ************************************
 */
open class ObjectLoader {
    /**
     *
     * @param observable
     * @param <T>
     * @return
    </T> */
    protected fun <T> observe(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}