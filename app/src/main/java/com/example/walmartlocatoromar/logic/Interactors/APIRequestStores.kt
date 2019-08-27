package com.example.walmartlocatoromar.logic.Interactors

import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.logic.data.network.ApiStoreResponse
import com.example.walmartlocatoromar.logic.data.network.framework.retrofit.IListStore
import com.example.walmartlocatoromar.tools.Server
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIRequestStores {

    interface OnFinishedListener{
        fun OperationSuccess(listItems: List<Store>)
        fun OperationError(messageError: String)
    }

    fun ListItems(listener: OnFinishedListener){
        var retrofitStores = Retrofit.Builder()
            .baseUrl(Server.SERVICE_DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiStores = retrofitStores.create(IListStore::class.java)
        var callApi = apiStores.getStoresList()

        callApi.enqueue(object : Callback<ApiStoreResponse> {
            override fun onFailure(call: Call<ApiStoreResponse>, t: Throwable) {
                t.message?.let { listener.OperationError(it) }
            }

            override fun onResponse(call: Call<ApiStoreResponse>, response: Response<ApiStoreResponse>
            ) {
                response.body()?.responseArray?.let { listener.OperationSuccess(it) }
            }

        })

    }
}