package com.example.walmartlocatoromar.logic.data.models

import java.io.Serializable

data class Store(
    var codeMessage: Int,
    var message: String,
    var id: Int,
    var businessID: String,
    var storeID: String,
    var name: String,
    var address: String,
    var telephone: String,
    var manager: String,
    var zipCode: String,
    var latSpan: String,
    var latPoint: String,
    var lonPoint: String,
    var opens: String,
    var distanceTo: Float) : Serializable{
}