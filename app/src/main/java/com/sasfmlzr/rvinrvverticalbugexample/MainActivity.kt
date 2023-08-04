package com.sasfmlzr.rvinrvverticalbugexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvItem = findViewById<RecyclerView>(R.id.rv_item)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        val itemAdapter = ItemAdapter(buildItemList())
        rvItem.adapter = itemAdapter
        rvItem.layoutManager = layoutManager
    }

    private fun buildItemList(): List<Item> {
        val itemList: MutableList<Item> = ArrayList()
        for (i in 0..9) {
            val item = Item("Item $i", buildSubItemList())
            itemList.add(item)
        }
        return itemList
    }

    private fun buildSubItemList(): List<SubItem> {
        val subItemList: MutableList<SubItem> = ArrayList()
        for (i in 0..99) {
            val subItem = SubItem("Sub Item $i")
            subItemList.add(subItem)
        }
        return subItemList
    }
}