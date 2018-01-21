package com.isla.viewmodeltest

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData

class AdsViewModel(application: Application) : AndroidViewModel(application) {

    val adsLiveData = AdsLiveData()

    val isLoadingLiveData = MediatorLiveData<Boolean>().apply {
        this.addSource(adsLiveData) { this.value = false }
    }

    fun loadAds() {
        isLoadingLiveData.value = true
        adsLiveData.loadAds()
    }
}