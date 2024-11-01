package com.ort.waynimovil.data.model

data class Transaction(
    val amount: Double,
    val description: String,
    val currency: String,
    val type: String,
    val date: String
)
