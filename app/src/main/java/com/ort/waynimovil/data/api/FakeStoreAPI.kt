package com.ort.waynimovil.data.api

import com.ort.waynimovil.data.model.LoginRequest
import com.ort.waynimovil.data.model.LoginResponse
import com.ort.waynimovil.data.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FakeStoreAPI {
    @POST("/auth/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/users/{id}")
    suspend fun getUserInfo(@Path("id") id: Int): UserResponse
}