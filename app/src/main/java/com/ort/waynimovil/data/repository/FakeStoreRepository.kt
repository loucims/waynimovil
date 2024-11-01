package com.ort.waynimovil.data.repository

import com.ort.waynimovil.data.api.FakeStoreAPI
import com.ort.waynimovil.data.model.LoginRequest
import com.ort.waynimovil.data.model.LoginResponse
import com.ort.waynimovil.data.model.UserResponse

class FakeStoreRepository(private val api: FakeStoreAPI) {

    suspend fun loginUser(username: String, password: String): LoginResponse {
        val loginRequest = LoginRequest(username, password)
        return api.loginUser(loginRequest)
    }

    suspend fun getUserInfo(id: Int): UserResponse {
        return api.getUserInfo(id)
    }
}