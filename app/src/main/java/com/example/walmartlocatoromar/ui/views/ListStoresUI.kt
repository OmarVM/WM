package com.example.walmartlocatoromar.ui.views

import com.example.walmartlocatoromar.logic.data.models.Store

interface ListStoresUI {

    fun infoFromData(listItems: List<Store>)
    fun infoFromDataError(messageError:String)

    fun listFilterByDistance(listItems: List<Store>)
}