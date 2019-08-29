package com.example.walmartlocatoromar.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.walmartlocatoromar.R
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.tools.Constants
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var mMap: GoogleMap
    private lateinit var store: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        store = intent.getSerializableExtra(Constants.ACTIVITY_DETAILS) as Store
        Log.d("TAG", store.toString())

        store_name_desc.text = store.name
        store_address_desc.text = store.address
        store_address_cp_desc.text = store.zipCode
        store_address_phone_desc.text = store.telephone
        store_admin_desc.text = store.manager
        store_distance_desc.text = store.distanceTo.toString()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_desc) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        val zoom = CameraUpdateFactory.zoomTo(15F)
        val storeLocation = LatLng(store.latPoint.toDouble(), store.lonPoint.toDouble())
        Log.d("TAG", "LatLon -> ${store.latPoint.toDouble()} <-> ${store.lonPoint.toDouble()}")
        mMap.addMarker(MarkerOptions().position(storeLocation).title(store.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(storeLocation))
        mMap.animateCamera(zoom)
    }
}
