package com.yz3ro.pharmacies.data.datasource

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.yz3ro.pharmacies.data.entity.PharmacyResponse
import com.yz3ro.pharmacies.data.retrofit.PharmacyApiService
import com.yz3ro.pharmacies.util.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class PharmaciesDataSource(var pas : PharmacyApiService) {

    suspend fun getNearbyPharmacies(latitude: Double, longitude: Double, apiKey: String = API_KEY): PharmacyResponse {
        return pas.getNearbyPharmacies(latitude, longitude, apiKey)
    }


}
