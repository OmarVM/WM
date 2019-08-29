package com.example.walmartlocatoromar.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlocatoromar.R
import com.example.walmartlocatoromar.logic.data.models.Store
import com.example.walmartlocatoromar.ui.views.ListStoresUI
import kotlinx.android.synthetic.main.item_store_list.view.*

class AdapterListStores(var listStores: List<Store>, val view: ListStoresUI) : RecyclerView.Adapter<AdapterListStores.ItemStoreHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStoreHolder {
        var layoutInflate = LayoutInflater.from(parent.context).inflate(R.layout.item_store_list, parent, false)
        return ItemStoreHolder(layoutInflate)
    }

    override fun getItemCount(): Int {
        return listStores.size
    }

    override fun onBindViewHolder(holder: ItemStoreHolder, position: Int) {
        var item = listStores[position]
        holder.BindItem(item, view)
    }

    class ItemStoreHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun BindItem(item: Store, viewItem: ListStoresUI){
            itemView.store_name.text = item.name
            itemView.store_address.text = item.address
            itemView.store_distance.text = item.distanceTo.toString()

            itemView.setOnClickListener {
                viewItem.onClickItemAdapter(item)
            }
        }
    }
}