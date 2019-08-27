package com.example.walmartlocatoromar.logic.data.network

import com.example.walmartlocatoromar.logic.data.models.Store

data class ApiStoreResponse (var codeMessage: Int,
                             var message:String,
                             var responseArray: List<Store>){
}