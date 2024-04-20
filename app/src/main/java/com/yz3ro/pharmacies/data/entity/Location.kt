package com.yz3ro.pharmacies.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(
    val latitude : Double,
    val longitude : Double
) : Serializable
