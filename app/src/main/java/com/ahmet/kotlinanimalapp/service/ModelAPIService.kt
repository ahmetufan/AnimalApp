package com.ahmet.kotlinanimalapp.service

import com.ahmet.kotlinanimalapp.model.Model2
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ModelAPIService {

    private val BASE_URL="http://www.adddisyon.online/"

    private val retrofit=Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).
        addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
        .create(ModelAPI::class.java)

    fun getAPI():Single<List<Model2>> {
        return retrofit.getData()
    }
}