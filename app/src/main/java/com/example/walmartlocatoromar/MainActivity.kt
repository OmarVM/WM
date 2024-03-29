package com.example.walmartlocatoromar

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.tools.Constants
import com.example.walmartlocatoromar.ui.adapters.AdapterListStores
import com.example.walmartlocatoromar.ui.presenters.ListFilterByDistance
import com.example.walmartlocatoromar.ui.presenters.ListFilterByDistanceImple
import com.example.walmartlocatoromar.ui.presenters.ListStoresImple
import com.example.walmartlocatoromar.ui.views.ListStoresUI
import com.example.walmartlocatoromar.ui.views.activities.Details
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListStoresUI, OnMapReadyCallback {

    private lateinit var presenter: ListStoresImple
    private lateinit var listByDistancePresenter: ListFilterByDistance
    private lateinit var context: Context
    private lateinit var mAdapter: AdapterListStores

    private lateinit var listItems: List<Store>
    private lateinit var listItemsFilter: List<Store>

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = applicationContext
        presenter = ListStoresImple(this)
        presenter.doRequestAPI()
    }

    override fun infoFromData(listItems: List<Store>) {
        Log.d("TAG", "Total Items From Data: ${listItems.size}")
        this.listItems = listItems
        requestUserPermissionLocation()
    }

    override fun infoFromDataError(messageError: String) {
        Log.d("TAG", messageError)
    }

    override fun listFilterByDistance(listItems: List<Store>) {
        Log.d("TAG", "Total Items Filter: ${listItems.size}")
        layout_content_wait.visibility = View.INVISIBLE
        this.listItemsFilter = listItems
        rv_list_stores.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mAdapter = AdapterListStores(listItems , this)
        rv_list_stores.adapter = mAdapter

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_main_view) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        if(listItemsFilter.isNotEmpty()){
            val zoom = CameraUpdateFactory.zoomTo(10F)
            for (store in listItemsFilter){
                val storeLocation = LatLng(store.latPoint.toDouble(), store.lonPoint.toDouble())
                Log.d("TAG", "LatLon -> ${store.latPoint.toDouble()} <-> ${store.lonPoint.toDouble()}")
                mMap.addMarker(MarkerOptions().position(storeLocation).title(store.name))
            }
            val center = LatLng(19.432304, -99.178723)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(center))
            mMap.animateCamera(zoom)
        }
    }

    override fun onClickItemAdapter(item: Store) {
        var intent = Intent(context, Details::class.java)
        intent.putExtra(Constants.ACTIVITY_DETAILS, item)
        startActivity(intent)
    }

    fun requestUserPermissionLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            val listPermission = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
            ActivityCompat.requestPermissions(this, listPermission, Constants.KEY_RESQUEST_PERMISSION_LOCATION)
        }else{
            listByDistancePresenter = ListFilterByDistanceImple(context, listItems, this)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            Constants.KEY_RESQUEST_PERMISSION_LOCATION -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    Log.d("TAG", "Permiso Otorgado.")
                    listByDistancePresenter = ListFilterByDistanceImple(context, listItems, this)
                }else{
                    Log.d("TAG", "Permiso No Otorgado.")
                    listFilterByDistance(listItems)
                }
            }
        }
    }
}
