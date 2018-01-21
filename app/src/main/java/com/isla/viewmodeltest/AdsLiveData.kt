package com.isla.viewmodeltest

import android.arch.lifecycle.MediatorLiveData
import com.isla.viewmodeltest.network.NetworkProvider
import com.isla.viewmodeltest.network.bean.AdsBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class AdsLiveData : MediatorLiveData<Pair<AdsBean?, Throwable?>>() {
    private var disposable: Disposable? = null

    fun loadAds() {
        disposable = NetworkProvider.getAds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data -> this@AdsLiveData.value = Pair(data.data, null) },
                        { error -> this@AdsLiveData.value = Pair(null, error) })
    }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}