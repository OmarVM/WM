package com.example.walmartlocatoromar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.presenters.ListStores
import com.example.walmartlocatoromar.ui.views.ListStoresUI

class MainActivity : AppCompatActivity(), ListStoresUI {

    private lateinit var presenter: ListStores

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.doRequestAPI()
    }


    override fun infoFromData(listItems: List<Store>) {
         Log.d("TAG", listItems.toString())
    }

    override fun infoFromDataError(messageError: String) {
        Log.d("TAG", messageError)
    }
}
