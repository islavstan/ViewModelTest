package com.isla.viewmodeltest.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

class AdsBean(@JsonProperty("id")
              var id: Long? = null,
              @JsonProperty("title")
              var title: String? = null,
              @JsonProperty("url")
              var url: String? = null)