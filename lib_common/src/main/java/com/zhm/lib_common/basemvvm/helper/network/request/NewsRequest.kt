package com.zhm.lib_common.basemvvm.helper.network.request

import com.zhm.lib_common.basemvvm.helper.network.databeam.NewsResp
import retrofit2.http.GET
import retrofit2.http.Url

/**
 ************************************
 *@Author revolve
 *创建时间：2019/9/3  19:15
 *用途
 ************************************
 */
interface NewsRequest {
    /**
     *
     * @param url
     * @param
     * @param
     * @return
     */
    @GET
    suspend fun getGank(@Url url: String/*, @Path("count")int count,@Path("page")int page*/): NewsResp
}