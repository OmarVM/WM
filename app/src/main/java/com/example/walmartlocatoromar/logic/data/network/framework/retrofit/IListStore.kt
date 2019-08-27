package com.example.walmartlocatoromar.logic.data.network.framework.retrofit

import com.example.walmartlocatoromar.logic.data.network.ApiStoreResponse
import com.example.walmartlocatoromar.tools.Server
import retrofit2.Call
import retrofit2.http.GET

interface IListStore {

    @GET(Server.SERVICE_LIST_STORES)
    fun getStoresList() : Call<ApiStoreResponse>
}