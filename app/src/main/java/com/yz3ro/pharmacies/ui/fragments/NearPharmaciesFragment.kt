package com.yz3ro.pharmacies.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.yz3ro.pharmacies.R
import com.yz3ro.pharmacies.adapters.NearPharmaciesAdapter
import com.yz3ro.pharmacies.databinding.FragmentHomeBinding
import com.yz3ro.pharmacies.databinding.FragmentNearPharmaciesBinding
import com.yz3ro.pharmacies.ui.viewmodels.HomeViewModel
import com.yz3ro.pharmacies.ui.viewmodels.NearPharmaciesViewModel
import com.yz3ro.pharmacies.util.Constants.API_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NearPharmaciesFragment : Fragment() {
    private lateinit var binding: FragmentNearPharmaciesBinding
    private val viewModel: NearPharmaciesViewModel by viewModels()
    private lateinit var adapter: NearPharmaciesAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_near_pharmacies, container, false)
        val bundle:NearPharmaciesFragmentArgs by navArgs()
        val getLocation = bundle.location
        adapter = NearPharmaciesAdapter(requireContext(), listOf())
        binding.rvNearPharmices.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvNearPharmices.layoutManager = layoutManager
        viewModel.pharmacies.observe(viewLifecycleOwner) { pharmacies ->
            Log.d("NearPharmaciesFragment", "Pharmacies: $pharmacies")
            adapter.updateList(pharmacies)
        }
        viewModel.getNearbyPharmacies(getLocation.latitude,getLocation.longitude,API_KEY)
        return binding.root
    }



}