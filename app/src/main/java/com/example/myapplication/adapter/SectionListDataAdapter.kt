package com.example.myapplication.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.models.SingleItemModel
import java.util.*

class SectionListDataAdapter(private val itemsList: ArrayList<SingleItemModel>?) :
    RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SingleItemRowHolder {
        return SingleItemRowHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.list_single_card, null))
    }

    override fun onBindViewHolder(holder: SingleItemRowHolder, i: Int) {
        val singleItem = itemsList!![i]
        holder.tvTitle.text = singleItem.name
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }

    inner class SingleItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById<View>(R.id.tvTitle) as TextView

    }

}