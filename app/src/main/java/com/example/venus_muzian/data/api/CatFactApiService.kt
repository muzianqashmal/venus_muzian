package com.example.venus_muzian.data.api

import com.example.venus_muzian.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
