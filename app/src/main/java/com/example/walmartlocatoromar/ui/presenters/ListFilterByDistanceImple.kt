package com.example.walmartlocatoromar.ui.presenters

import android.content.Context
import com.example.walmartlocatoromar.logic.Interactors.FilterItemsByDistance
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.views.ListStoresUI

class ListFilterByDistanceImple : ListFilterByDistance {

    private var context: Context
    private var listItems: List<Store>
    private var view: ListStoresUI

    constructor(context: Context, listItems: List<Store>, view: ListStoresUI){
        this.context = context
        this.listItems = listItems
        this.view = view
        var filter = FilterItemsByDistance(context, this)
        filter.getLocation(listItems, 0.0)
    }

    override fun listSort(listItems: List<Store>) {
       view.listFilterByDistance(listItems)
    }
}