package com.yz3ro.pharmacies.ui.viewmodels

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yz3ro.pharmacies.data.datasource.PharmaciesDataSource
import com.yz3ro.pharmacies.data.entity.Pharmacy
import com.yz3ro.pharmacies.data.entity.PharmacyResponse
import com.yz3ro.pharmacies.data.repo.PharmaciesRepository
import com.yz3ro.pharmacies.util.Constants.REQUEST_LOCATION_PERMISSION
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var repository: PharmaciesRepository) : ViewModel() {
    private val _pharmacies = MutableLiveData<List<Pharmacy>>()
    val pharmacies: LiveData<List<Pharmacy>>
        get() = _pharmacies

    fun getNearbyPharmacies(latitude: Double, longitude: Double, apiKey: String) {
        viewModelScope.launch {
            val response = repository.getNearbyPharmacies(latitude, longitude, apiKey)
            if (response.status == "success") {
                _pharmacies.value = response.data
            } else {

            }
        }
    }


}