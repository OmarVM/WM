package com.example.walmartlocatoromar.logic.Interactors

import android.util.Log
import com.example.walmartlocatoromar.logic.data.models.Store

class SortListItems {


    fun sortListAsc(listItemsAux: List<Store>): List<Store>{
        var listItems = listItemsAux as ArrayList
        listItems.sortBy { filterByDistance(it) }
        listItems.forEach { Log.d("TAG","Lista Ordenada -> " +  it.distanceTo.toString()) }

        return listItems
    }

    fun filterByDistance(store: Store): Float = store.distanceTo
}