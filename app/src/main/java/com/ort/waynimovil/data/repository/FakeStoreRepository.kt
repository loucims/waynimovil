package com.ort.waynimovil.data.repository

import com.ort.waynimovil.data.api.FakeStoreAPI
import com.ort.waynimovil.data.model.LoginRequest
import com.ort.waynimovil.data.model.LoginResponse
import com.ort.waynimovil.data.model.UserResponse
import retrofit2.HttpException

class FakeStoreRepository(private val api: FakeStoreAPI) {

    suspend fun loginUser(username: String, password: String): Result<LoginResponse> {
        return try {
            val loginRequest = LoginRequest(username, password)
            val response = api.loginUser(loginRequest)
            Result.success(response)
        } catch (e: HttpException) {
            if (e.code() == 401) {
                Result.failure(Exception("Not authorized"))
            } else {
                Result.failure(e)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserInfo(id: Int): Result<UserResponse> {
        return try {
            val response = api.getUserInfo(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}