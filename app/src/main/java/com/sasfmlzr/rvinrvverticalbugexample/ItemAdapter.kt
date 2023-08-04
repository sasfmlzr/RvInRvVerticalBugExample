package com.sasfmlzr.rvinrvverticalbugexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sasfmlzr.rvinrvverticalbugexample.ItemAdapter.ItemViewHolder

class ItemAdapter internal constructor(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemViewHolder>() {
    private val viewPool = RecycledViewPool()
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_item, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        val item = itemList[i]
        itemViewHolder.tvItemTitle.text = item.itemTitle

        // Create layout manager with initial prefetch item count
        val layoutManager = LinearLayoutManager(
            itemViewHolder.rvSubItem.context,
            LinearLayoutManager.VERTICAL,
            false
        )

        // Create sub item view adapter
        val subItemAdapter = SubItemAdapter(item.subItemList)
        itemViewHolder.rvSubItem.layoutManager = layoutManager
        itemViewHolder.rvSubItem.adapter = subItemAdapter
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool)

        println("Parent $itemViewHolder at index $i")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : ViewHolder(itemView) {
        val tvItemTitle: TextView
        val rvSubItem: RecyclerView

        init {
            tvItemTitle = itemView.findViewById(R.id.tv_item_title)
            rvSubItem = itemView.findViewById(R.id.rv_sub_item)
        }
    }
}
