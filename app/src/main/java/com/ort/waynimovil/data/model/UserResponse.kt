package com.ort.waynimovil.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val address: Address,
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val name: Name,
    val phone: String,
    @SerializedName("__v") val version: Int
)

data class Address(
    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String
)

data class Geolocation(
    val lat: String,
    @SerializedName("long") val lng: String
)

data class Name(
    val firstname: String,
    val lastname: String
)