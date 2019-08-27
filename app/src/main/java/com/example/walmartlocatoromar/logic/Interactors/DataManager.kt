package com.example.walmartlocatoromar.logic.Interactors

import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.presenters.ListStores

class DataManager: APIRequestStores.OnFinishedListener {

    private var requestAPI: APIRequestStores = APIRequestStores()
    private lateinit var presenter: ListStores


    fun doRequestAPI(presenter: ListStores){
        requestAPI.ListItems(this)
    }

    override fun OperationSuccess(listItems: List<Store>) {
       presenter.OperationSuccess(listItems)
    }

    override fun OperationError(messageError: String) {
        presenter.OperationError(messageError)
    }
}