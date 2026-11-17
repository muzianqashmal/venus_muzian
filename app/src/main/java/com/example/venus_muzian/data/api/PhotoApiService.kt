package com.example.venus_muzian.data.api

import com.example.venus_muzian.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
