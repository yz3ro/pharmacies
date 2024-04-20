package com.yz3ro.pharmacies.util

import android.view.View
import androidx.navigation.Navigation

fun Navigation.navigate(it: View, id:Int){
    findNavController(it).navigate(id)
}