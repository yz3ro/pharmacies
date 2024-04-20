package com.yz3ro.pharmacies.data.repo

import android.content.Context
import android.location.Location
import com.yz3ro.pharmacies.data.datasource.PharmaciesDataSource
import com.yz3ro.pharmacies.data.entity.Pharmacy
import com.yz3ro.pharmacies.data.entity.PharmacyResponse

class PharmaciesRepository(private val dataSource: PharmaciesDataSource) {
    suspend fun getNearbyPharmacies(latitude: Double, longitude: Double, apiKey: String): PharmacyResponse {
        return dataSource.getNearbyPharmacies(latitude, longitude, apiKey)
    }


}