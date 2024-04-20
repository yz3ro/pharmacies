package com.yz3ro.pharmacies.data.retrofit

import com.yz3ro.pharmacies.data.entity.PharmacyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PharmacyApiService {
    @GET("pharmacies-on-duty/locations")
    suspend fun getNearbyPharmacies(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("apiKey") apiKey: String
    ): PharmacyResponse
}
