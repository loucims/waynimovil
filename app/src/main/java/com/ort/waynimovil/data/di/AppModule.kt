package com.ort.waynimovil.data.di

import androidx.compose.ui.tooling.preview.Preview
import com.ort.waynimovil.data.api.FakeStoreAPI
import com.ort.waynimovil.data.api.FakeStoreRetrofit
import com.ort.waynimovil.data.repository.BancoRepository
import com.ort.waynimovil.data.repository.FakeStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFakeStoreApi(): FakeStoreAPI {
        return FakeStoreRetrofit.apiService
    }

    @Provides
    @Singleton
    fun provideFakeStoreRepository(api: FakeStoreAPI): FakeStoreRepository {
        return FakeStoreRepository(api)
    }

    @Provides
    @Singleton
    fun provideBancoRepository(): BancoRepository {
        return BancoRepository()
    }
}