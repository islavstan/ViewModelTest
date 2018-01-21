package com.isla.architecturecomponentsexample.network

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


class RestClient {

    companion object {
        fun getInstance() = createRetrofit()


        private val DATE_PATTERN_BASE = "yyyy-MM-dd"

        private fun createRetrofit() = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(createObjectMapper()))
                .baseUrl(API_ENDPOINT)
                .build()

        private fun createObjectMapper() = with(ObjectMapper()) {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
            setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
            setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
            configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            dateFormat = SimpleDateFormat(DATE_PATTERN_BASE, Locale.getDefault())
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }
}