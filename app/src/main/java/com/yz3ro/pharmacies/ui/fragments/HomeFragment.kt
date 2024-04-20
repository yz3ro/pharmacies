package com.yz3ro.pharmacies.ui.fragments

import android.Manifest
import android.app.Activity
import android.content.Context
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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.yz3ro.pharmacies.R
import com.yz3ro.pharmacies.data.datasource.PharmaciesDataSource
import com.yz3ro.pharmacies.data.entity.Pharmacy
import com.yz3ro.pharmacies.data.repo.PharmaciesRepository
import com.yz3ro.pharmacies.data.retrofit.ApiClient
import com.yz3ro.pharmacies.data.retrofit.PharmacyApiService
import com.yz3ro.pharmacies.databinding.FragmentHomeBinding
import com.yz3ro.pharmacies.ui.viewmodels.HomeViewModel
import com.yz3ro.pharmacies.util.Constants.API_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment() : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var flpc : FusedLocationProviderClient
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNearbyPharmacies(40.975447, 29.260145423293462, API_KEY)
        viewModel.pharmacies.observe(viewLifecycleOwner, Observer { pharmacies ->
            Log.e("eczane",pharmacies.toString())
        })
    }



}
