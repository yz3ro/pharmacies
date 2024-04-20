package com.yz3ro.pharmacies.data.entity

data class Pharmacy(
    val pharmacyID: Int,
    val pharmacyName: String,
    val address: String,
    val city: String,
    val district: String,
    val town: String?,
    val directions: String?,
    val phone: String,
    val phone2: String?,
    val pharmacyDutyStart: String,
    val pharmacyDutyEnd: String,
    val latitude: Double,
    val longitude: Double,
    val distanceMt: Int,
    val distanceKm: Double,
    val distanceMil: Double
)