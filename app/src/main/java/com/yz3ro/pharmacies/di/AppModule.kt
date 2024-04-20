package com.yz3ro.pharmacies.di

import com.yz3ro.pharmacies.data.datasource.PharmaciesDataSource
import com.yz3ro.pharmacies.data.repo.PharmaciesRepository
import com.yz3ro.pharmacies.data.retrofit.PharmacyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providePharmacyApiService(): PharmacyApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.nosyapi.com/apiv2/service/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PharmacyApiService::class.java)
    }

    @Singleton
    @Provides
    fun providePharmaciesDataSource(apiService: PharmacyApiService): PharmaciesDataSource {
        return PharmaciesDataSource(apiService)
    }

    @Singleton
    @Provides
    fun providePharmaciesRepository(dataSource: PharmaciesDataSource): PharmaciesRepository {
        return PharmaciesRepository(dataSource)
    }
}