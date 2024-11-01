package com.ort.waynimovil.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.yourservice.com/"

    val apiService: ApiService  by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

//    val firestore = FirebaseFirestore.getInstance()
//    firestore.collection("test").get().addOnSuccessListener {
//        for (document in it) {
//            println("${document.id} => ${document.data}")
//        }
//    } Funciona firestore!!!