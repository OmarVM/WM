package com.example.walmartlocatoromar.logic.Interactors

import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.presenters.ListStores

class DataManager: APIRequestStores.OnFinishedListener {

    private lateinit var presenter: ListStores

    fun doRequestAPI(presenter: ListStores){
        this.presenter = presenter
        var requestAPI = APIRequestStores()
        requestAPI.ListItems(this)
    }

    override fun OperationSuccess(listItems: List<Store>) {
       presenter.OperationSuccess(listItems)
    }

    override fun OperationError(messageError: String) {
        presenter.OperationError(messageError)
    }
}