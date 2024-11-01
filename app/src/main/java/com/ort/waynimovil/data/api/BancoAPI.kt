package com.ort.waynimovil.data.api

import com.ort.waynimovil.data.model.Transaction


interface BancoAPI {
    suspend fun getCreditCardTransactionsForUser(id: String): List<Transaction>
}