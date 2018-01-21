package com.isla.viewmodeltest.network.modules

import com.isla.architecturecomponentsexample.network.Api
import com.isla.architecturecomponentsexample.network.RestClient

class AdsModuleImpl : AdsModule {
    private var api: Api = RestClient.getInstance().create(Api::class.java)
    override fun getAds() = api.getAds("")
}