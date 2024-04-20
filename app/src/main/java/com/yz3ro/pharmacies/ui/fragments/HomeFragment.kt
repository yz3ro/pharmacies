package com.yz3ro.pharmacies.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.yz3ro.pharmacies.R
import com.yz3ro.pharmacies.databinding.FragmentHomeBinding
import com.yz3ro.pharmacies.ui.viewmodels.HomeViewModel
import com.yz3ro.pharmacies.util.Constants.API_KEY
import com.yz3ro.pharmacies.util.navigate
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment() : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var flpc: FusedLocationProviderClient
    private lateinit var locationTask: Task<Location>
    private val LOCATION_PERMISSION_REQUEST_CODE = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        flpc = LocationServices.getFusedLocationProviderClient(requireActivity())
        binding.btnLocation.setOnClickListener {
            checkLocationPermission()
        }
        return binding.root
    }

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getLocation()
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    private fun getLocation() {
        try {
            locationTask = flpc.lastLocation
            locationTask.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val bundle =HomeFragmentDirections.actionHomeFragmentToNearPharmaciesFragment(
                        com.yz3ro.pharmacies.data.entity.Location(location.latitude,location.longitude))
                    Navigation.findNavController(requireView()).navigate(bundle)
                    Log.e("location", "${location.latitude}  ${location.longitude}")
                } else {
                    Log.e("location", "enlem ve boylam bilgisi bulunamadı")
                }
            }.addOnFailureListener { e ->
                Log.e("location", "Konum alınamadı: ${e.message}")
            }
        } catch (e: SecurityException) {
            // İzin reddedildi veya diğer izin hatası
            e.printStackTrace()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "izin onaylandı", Toast.LENGTH_SHORT).show()
                getLocation()
            } else {
                Toast.makeText(requireContext(), "izin onaylanmadı", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

