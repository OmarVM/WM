package com.example.walmartlocatoromar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.adapters.AdapterListStores
import com.example.walmartlocatoromar.ui.presenters.ListStoresImple
import com.example.walmartlocatoromar.ui.views.ListStoresUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListStoresUI {

    private lateinit var presenter: ListStoresImple
    private lateinit var context: Context
    private lateinit var mAdapter: AdapterListStores

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = applicationContext
        presenter = ListStoresImple(this)
        presenter.doRequestAPI()
    }


    override fun infoFromData(listItems: List<Store>) {
        Log.d("TAG", listItems.toString())
        rv_list_stores.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mAdapter = AdapterListStores(listItems)
        rv_list_stores.adapter = mAdapter
    }

    override fun infoFromDataError(messageError: String) {
        Log.d("TAG", messageError)
    }
}
