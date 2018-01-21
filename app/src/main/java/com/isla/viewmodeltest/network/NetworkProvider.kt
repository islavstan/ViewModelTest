package com.isla.viewmodeltest.network

import com.isla.viewmodeltest.network.modules.AdsModuleImpl

object NetworkProvider {
    val adsModule = AdsModuleImpl()

    fun getAds() = adsModule.getAds()

}