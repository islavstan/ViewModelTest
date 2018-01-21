package com.isla.architecturecomponentsexample.network

import com.isla.viewmodeltest.network.bean.GetAdsBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface Api {
    @FormUrlEncoded
    @POST("api/get-ads")
    fun getAds(@Field("key") key: String): Observable<GetAdsBean>
}