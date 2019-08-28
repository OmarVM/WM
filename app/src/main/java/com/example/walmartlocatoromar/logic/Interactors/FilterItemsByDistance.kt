package com.example.walmartlocatoromar.logic.Interactors

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.util.Log
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.presenters.ListFilterByDistance

class FilterItemsByDistance {

    private var context: Context
    private var presenter: ListFilterByDistance

    constructor(context: Context, presenter: ListFilterByDistance){
        this.context = context
        this.presenter = presenter
    }


    @SuppressLint("MissingPermission")
    fun getLocation(listItems: List<Store>, limitDistance: Double){
        var locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gpsEnabled: Boolean = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (gpsEnabled){
            var currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            for (store in listItems){
                var storeLocation = Location("storeLocation")
                storeLocation.latitude = store.latPoint.toDouble()
                storeLocation.longitude = store.lonPoint.toDouble()
                var distanceResult = currentLocation.distanceTo(storeLocation)
                distanceResult = Math.round(distanceResult / 1000).toFloat()
                store.distanceTo = distanceResult
            }
            sortListAsc(listItems)
        }
    }

    fun sortListAsc(listItemsAux: List<Store>){
        var listItems = listItemsAux as ArrayList
        listItems.sortBy { filterByDistance(it) }
        listItems.forEach { Log.d("TAG","Lista Ordenada -> " +  it.distanceTo.toString()) }

        limitNumberItems(listItems)
    }

    fun filterByDistance(store: Store): Float = store.distanceTo

    fun limitNumberItems(listItems: List<Store>){
        var listWithLimit = ArrayList<Store>()
        (0..24).forEach{ listWithLimit.add(listItems[it])}
        presenter.listSort(listWithLimit)
    }
}