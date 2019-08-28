package com.example.walmartlocatoromar.logic.Interactors

import com.example.walmartlocatoromar.logic.data.models.Store

class LimitItemsOnList {

    fun getListByLimit(listItems: List<Store>, limitItems: Int) : List<Store>{
        var listWithLimit = ArrayList<Store>()
        var limit = limitItems -1
        (0..limit).forEach{ listWithLimit.add(listItems[it])}
        return listWithLimit
    }
}