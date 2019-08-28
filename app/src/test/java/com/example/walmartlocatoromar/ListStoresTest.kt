package com.example.walmartlocatoromar

import com.example.walmartlocatoromar.logic.Interactors.LimitItemsOnList
import com.example.walmartlocatoromar.logic.Interactors.SortListItems
import com.example.walmartlocatoromar.logic.data.models.Store
import org.junit.Test

import org.junit.Assert.*

class ListStoresTest {

    @Test
    fun evaluateSortAscItemsOnList(){
        var listStore = ArrayList<Store>()
        var store1 = Store(0,"",0,"4","1003","PLAYA DEL CARMEN","REGION 01, MANZANA 040, LOTE 001-1 S/N, SOL. CENTRO","803 0911 / 0089 / 0316 / 0335 / 0363","JUAN FRANCISCO VILLAFAÑA BALTIERRA","77710","20.6279","20.6279","-87.0745","07:00 a 23:00 / UTC–5 - V (UTC–5)", 34.0F)
        var store2 = Store(0,"",0,"7","1007","MONCLOVA","AV. MADERO NO. 227 COL. CENTRO","6648 2579 AL 89/ 2397","JUAN JOSE DURAN VILLASANA","25700","26.9076","26.9076","-101.424","07:00 a 23:00 / UTC–6 - V (UTC–5)", 12.0F)
        var store3 = Store(0,"",0,"9","1016","MERIDA NORTE", "CALLE 30 NO. 185, ENTRE CALLE 23 Y PERIFÉRICO, COL. SAN RAMÓN NORTE","941 5863/ 5864/ 5865/ 5866/ 5867/ 5868/ 5869","JAVIER PONCE LARRINUA","97117","21.0386","21.0386","-89.6025","07:00 a 23:00 / UTC–6 - V (UTC–5)", 56.0F)
        listStore.add(store1)
        listStore.add(store2)
        listStore.add(store3)

        var listSort = SortListItems()

        assertEquals(3, listSort.sortListAsc(listStore).size)
        assertEquals("MONCLOVA", listSort.sortListAsc(listStore)[0].name)
    }

    @Test
    fun evaluateSizeList(){
        var listStore = ArrayList<Store>()
        var store1 = Store(0,"",0,"4","1003","PLAYA DEL CARMEN","REGION 01, MANZANA 040, LOTE 001-1 S/N, SOL. CENTRO","803 0911 / 0089 / 0316 / 0335 / 0363","JUAN FRANCISCO VILLAFAÑA BALTIERRA","77710","20.6279","20.6279","-87.0745","07:00 a 23:00 / UTC–5 - V (UTC–5)", 34.0F)
        var store2 = Store(0,"",0,"7","1007","MONCLOVA","AV. MADERO NO. 227 COL. CENTRO","6648 2579 AL 89/ 2397","JUAN JOSE DURAN VILLASANA","25700","26.9076","26.9076","-101.424","07:00 a 23:00 / UTC–6 - V (UTC–5)", 12.0F)
        var store3 = Store(0,"",0,"9","1016","MERIDA NORTE", "CALLE 30 NO. 185, ENTRE CALLE 23 Y PERIFÉRICO, COL. SAN RAMÓN NORTE","941 5863/ 5864/ 5865/ 5866/ 5867/ 5868/ 5869","JAVIER PONCE LARRINUA","97117","21.0386","21.0386","-89.6025","07:00 a 23:00 / UTC–6 - V (UTC–5)", 56.0F)
        listStore.add(store1)
        listStore.add(store2)
        listStore.add(store3)

        var listWithLimit = LimitItemsOnList()

        assertEquals(1, listWithLimit.getListByLimit(listStore, 3).size)

    }
}