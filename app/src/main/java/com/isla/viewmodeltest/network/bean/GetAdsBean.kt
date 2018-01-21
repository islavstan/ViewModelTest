package com.isla.viewmodeltest.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

class GetAdsBean(@JsonProperty("data")
                 var data: AdsBean? = null)