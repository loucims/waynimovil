package com.ort.waynimovil.data.di

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WaynimovilApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializar Firebase
        FirebaseApp.initializeApp(this)
    }
}