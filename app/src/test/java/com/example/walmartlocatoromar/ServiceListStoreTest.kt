package com.example.walmartlocatoromar

import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.logic.data.network.ApiStoreResponse
import com.example.walmartlocatoromar.logic.data.network.framework.retrofit.IListStore
import org.junit.Test

import org.mockito.Mockito
import org.mockito.Mockito.`when`
import retrofit2.Call

class ServiceListStoreTest {

    @Test
    fun getServicesResponseTest(){
        var listStore = ArrayList<Store>()
        var store1 = Store(0,"",0,"4","1003","PLAYA DEL CARMEN","REGION 01, MANZANA 040, LOTE 001-1 S/N, SOL. CENTRO","803 0911 / 0089 / 0316 / 0335 / 0363","JUAN FRANCISCO VILLAFAÑA BALTIERRA","77710","20.6279","20.6279","-87.0745","07:00 a 23:00 / UTC–5 - V (UTC–5)", 0.0F)
        var store2 = Store(0,"",0,"4","1007","MONCLOVA","AV. MADERO NO. 227 COL. CENTRO","6648 2579 AL 89/ 2397","JUAN JOSE DURAN VILLASANA","25700","26.9076","26.9076","-101.424","07:00 a 23:00 / UTC–6 - V (UTC–5)", 0.0F)
        listStore.add(store1)
        listStore.add(store2)

        var dummyResponse = ApiStoreResponse(1,"Success", listStore)
        var serviceMock = Mockito.mock(IListStore::class.java)
       //`when`(serviceMock.getStoresList()).thenReturn(Call<dummyResponse>)
    }
}