package com.yz3ro.pharmacies.data.entity

data class PharmacyResponse(
    val status: String,
    val message: String,
    val messageTR: String,
    val systemTime: Long,
    val endpoint: String,
    val rowCount: Int,
    val creditUsed: Int,
    val data: List<Pharmacy>
)