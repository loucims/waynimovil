package com.ort.waynimovil.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakeStoreRetrofit {
    private const val BASE_URL = "https://fakestoreapi.com"

    val apiService: FakeStoreAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(FakeStoreAPI::class.java)
    }
}

//    val firestore = FirebaseFirestore.getInstance()
//    firestore.collection("test").get().addOnSuccessListener {
//        for (document in it) {
//            println("${document.id} => ${document.data}")
//        }
//    } Funciona firestore!!!