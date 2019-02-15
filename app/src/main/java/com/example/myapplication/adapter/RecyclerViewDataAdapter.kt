package com.example.myapplication.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.models.SectionDataModel
import java.util.*

class RecyclerViewDataAdapter : RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder>() {

    lateinit var dataList: ArrayList<SectionDataModel>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        return ItemRowHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item,null))
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, i: Int) {

        val singleSectionItems = dataList[i].allItemsInSection
        val itemListDataAdapter = SectionListDataAdapter(singleSectionItems)
        itemRowHolder.apply {
            recycler_view_list.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(
                    itemView.context, LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = itemListDataAdapter
                isNestedScrollingEnabled = false
            }
        }

    }

    fun updateDataList(list: ArrayList<SectionDataModel>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var recycler_view_list = view.findViewById<View>(R.id.recycler_view_list) as RecyclerView

    }

}