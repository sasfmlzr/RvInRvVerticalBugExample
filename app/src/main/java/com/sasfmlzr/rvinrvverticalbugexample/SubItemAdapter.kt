package com.sasfmlzr.rvinrvverticalbugexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sasfmlzr.rvinrvverticalbugexample.SubItemAdapter.SubItemViewHolder

class SubItemAdapter internal constructor(private val subItemList: List<SubItem?>?) :
    RecyclerView.Adapter<SubItemViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SubItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_sub_item, viewGroup, false)
        return SubItemViewHolder(view)
    }

    override fun onBindViewHolder(subItemViewHolder: SubItemViewHolder, i: Int) {
        val subItem = subItemList!![i]
        subItemViewHolder.tvSubItemTitle.text = subItem!!.subItemTitle
        println("Child $subItemViewHolder at index $i")
    }

    override fun getItemCount(): Int {
        return subItemList!!.size
    }

    inner class SubItemViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvSubItemTitle: TextView

        init {
            tvSubItemTitle = itemView.findViewById(R.id.tv_sub_item_title)
        }
    }
}
