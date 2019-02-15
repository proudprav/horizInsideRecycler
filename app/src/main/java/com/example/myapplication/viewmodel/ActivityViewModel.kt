package com.example.myapplication.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import com.example.myapplication.adapter.RecyclerViewDataAdapter
import com.example.myapplication.models.SectionDataModel
import com.example.myapplication.models.SingleItemModel
import java.util.*

class ActivityViewModel() : ViewModel() {
    lateinit var allSampleData: ArrayList<SectionDataModel>
    val dataAdapter: RecyclerViewDataAdapter = RecyclerViewDataAdapter()
    val  noInputTextVisibility : ObservableField<Boolean>? = ObservableField()

    fun buttonClick(length: String, column: String) {
        if (length.isNotBlank() && column.isNotBlank()) {
            loadData(length.toInt(), column.toInt())
        } else {
            allSampleData.clear()
            dataAdapter.updateDataList(allSampleData)
        }

    }


    fun loadData(count: Int, width: Int) {
        allSampleData = ArrayList()
        var index = 0

        while (index < count) {
            val dm = SectionDataModel()
            val singleItem = ArrayList<SingleItemModel>()
            for (j in 1..width) {
                if (j + index <= count)
                    singleItem.add(SingleItemModel("Item ${j + index}"))
                else
                    continue
            }
            index += width
            dm.allItemsInSection = singleItem
            allSampleData.add(dm)
        }
        dataAdapter.updateDataList(allSampleData)
    }
}