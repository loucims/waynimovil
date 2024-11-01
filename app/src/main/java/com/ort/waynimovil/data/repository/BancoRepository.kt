package com.ort.waynimovil.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.ort.waynimovil.data.api.BancoAPI
import com.ort.waynimovil.data.model.Transaction
import com.ort.waynimovil.data.model.dto.TransactionDTO
import kotlinx.coroutines.tasks.await

class BancoRepository : BancoAPI{

    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun getCreditCardTransactionsForUser(id: String): List<Transaction> {
        return try {
            val snapshot = firestore.collection("users").document(id).collection("credit_card_transactions").get().await()
            snapshot.documents.mapNotNull { document ->
                document.toObject(TransactionDTO::class.java)?.toTransaction()
            }
        } catch (e: Exception) {
            println("ERROR: $e")
            emptyList()
        }
    }
}