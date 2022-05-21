package com.ahmet.kotlinanimalapp.service

import com.ahmet.kotlinanimalapp.model.Model2
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ModelAPI {
    //   http://www.adddisyon.online/get_hayvan_bilgileri.php

    @GET("get_hayvan_bilgileri.php")
    fun getData() : Single<List<Model2>>
}