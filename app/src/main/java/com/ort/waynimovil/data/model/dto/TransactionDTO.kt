package com.ort.waynimovil.data.model.dto

import com.ort.waynimovil.data.model.Transaction

data class TransactionDTO(
    val amount: Double = 0.0,
    val description: String = "",
    val currency: String = "",
    val type: String = "",
    val date: String = ""
) {
    fun toTransaction() = Transaction(
        amount = amount,
        description = description,
        currency = currency,
        type = type,
        date = date
    )
}
