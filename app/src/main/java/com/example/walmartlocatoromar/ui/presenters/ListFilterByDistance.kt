package com.example.walmartlocatoromar.ui.presenters

import com.example.walmartlocatoromar.logic.data.models.Store

interface ListFilterByDistance {

    fun listSort(listItems: List<Store>)
}