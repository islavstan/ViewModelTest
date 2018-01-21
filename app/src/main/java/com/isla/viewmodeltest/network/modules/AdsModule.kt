package com.isla.viewmodeltest.network.modules

import com.isla.viewmodeltest.network.bean.GetAdsBean
import io.reactivex.Observable


interface AdsModule {
    fun getAds(): Observable<GetAdsBean>
}