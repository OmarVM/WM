package com.example.walmartlocatoromar.ui.presenters

import android.content.Context
import com.example.walmartlocatoromar.logic.Interactors.DataManager
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.views.ListStoresUI

class ListStoresImple: ListStores {

    private var view: ListStoresUI
    private var requestData: DataManager

    constructor(view: ListStoresUI){
        this.view = view
        requestData = DataManager()
    }

    override fun doRequestAPI() {
        requestData.doRequestAPI(this)
    }

    override fun OperationSuccess(listItems: List<Store>) {
         view.infoFromData(listItems)
    }

    override fun OperationError(messageError: String) {
        view.infoFromDataError(messageError)
    }
}