package com.example.mvvmwithhilt.api

import com.example.mvvmwithhilt.model.ResMarvelModel
import retrofit2.http.GET

interface AllRestEnds {

    @GET("demos/marvel/")
    suspend fun getMarvelList(): ResMarvelModel
}
