package com.example.walmartlocatoromar.ui.presenters

import com.example.walmartlocatoromar.logic.data.models.Store

interface ListStores {

    fun doRequestAPI()
    fun OperationSuccess(listItems: List<Store>)
    fun OperationError(messageError: String)
}