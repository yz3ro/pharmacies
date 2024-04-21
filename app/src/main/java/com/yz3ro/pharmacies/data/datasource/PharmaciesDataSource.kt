package com.yz3ro.pharmacies.data.datasource



import com.yz3ro.pharmacies.data.entity.PharmacyResponse
import com.yz3ro.pharmacies.data.retrofit.PharmacyApiService
import com.yz3ro.pharmacies.util.Constants.API_KEY


class PharmaciesDataSource(var pas : PharmacyApiService,) {
    suspend fun getNearbyPharmacies(latitude: Double, longitude: Double, apiKey: String = API_KEY): PharmacyResponse {
        return pas.getNearbyPharmacies(latitude, longitude, apiKey)
    }
}
