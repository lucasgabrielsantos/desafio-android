package com.lucas.desafioandroid.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.model.Users

class PicPayAdapter(
    private val getList: List<Users>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_user, parent, false)
        return PicPayViewHolder(view)
    }

    override fun getItemCount() = getList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PicPayViewHolder).onBindPicPay(getList[position])
    }
}