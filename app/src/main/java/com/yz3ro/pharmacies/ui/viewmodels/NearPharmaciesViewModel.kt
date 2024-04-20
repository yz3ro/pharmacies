package com.yz3ro.pharmacies.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yz3ro.pharmacies.data.entity.Pharmacy
import com.yz3ro.pharmacies.data.repo.PharmaciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NearPharmaciesViewModel @Inject constructor(var repository: PharmaciesRepository) : ViewModel() {
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