package com.example.walmartlocatoromar.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.walmartlocatoromar.R
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.tools.Constants
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var store = intent.getSerializableExtra(Constants.ACTIVITY_DETAILS) as Store
        Log.d("TAG", store.toString())

        store_name_desc.text = store.name
        store_address_desc.text = store.address
        store_address_cp_desc.text = store.zipCode
        store_address_phone_desc.text = store.telephone
        store_admin_desc.text = store.manager
        store_distance_desc.text = store.distanceTo.toString()
    }
}
