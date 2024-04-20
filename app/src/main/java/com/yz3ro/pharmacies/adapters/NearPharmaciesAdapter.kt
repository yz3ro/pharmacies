package com.yz3ro.pharmacies.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yz3ro.pharmacies.data.entity.Pharmacy
import com.yz3ro.pharmacies.databinding.ItemPharmacyBinding
import javax.inject.Singleton


class NearPharmaciesAdapter(var mContext: Context,var pharmacyList : List<Pharmacy>) : RecyclerView.Adapter<NearPharmaciesAdapter.MyViewHolder>() {
    inner class MyViewHolder(var design : ItemPharmacyBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = ItemPharmacyBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(design)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pharmacy = pharmacyList.get(position)
        val t = holder.design
        t.pharmacyName.text = pharmacy.pharmacyName
        t.pharmacyAdress.text = pharmacy.address
        t.pharmacyPhoneNumber.text = pharmacy.phone
        t.pharmacyDistrict.text = pharmacy.district

    }

    override fun getItemCount(): Int = pharmacyList.size
    fun updateList(newList: List<Pharmacy>) {
        pharmacyList = newList
        notifyDataSetChanged()
        Log.d("NearPharmaciesAdapter", "New list size: ${pharmacyList.size}")
    }
}