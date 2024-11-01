package com.ort.waynimovil.data.api

import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun getData(): List<Int>
}