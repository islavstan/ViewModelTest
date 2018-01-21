package com.isla.viewmodeltest

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.isla.viewmodeltest.base.BaseLifecycleActivity
import com.isla.viewmodeltest.network.bean.AdsBean

class MainActivity : BaseLifecycleActivity<AdsViewModel>() {
    override val viewModelClass = AdsViewModel::class.java
    private lateinit var tvTitle: TextView
    private lateinit var tvUrl: TextView
    private lateinit var bLoad: Button
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvUrl = findViewById<TextView>(R.id.tvUrl)
        bLoad = findViewById<Button>(R.id.bLoad)
        progress = findViewById<ProgressBar>(R.id.progress)
        bLoad.setOnClickListener {
            viewModel.loadAds()

        }
        observeLiveData()

    }

    private fun showProgress(isShow: Boolean) {
        progress.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    private fun loadData(bean: AdsBean) {
        if (bean != null) {
            tvTitle.text = bean.title
            tvUrl.text = bean.url
        }
    }

    private fun observeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer<Boolean> {
            it?.let { showProgress(it) }
        })
        viewModel.adsLiveData.observe(this, Observer<Pair<AdsBean?, Throwable?>> {
            it?.first?.let { loadData(it) }
            it?.second?.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        })

    }
}
