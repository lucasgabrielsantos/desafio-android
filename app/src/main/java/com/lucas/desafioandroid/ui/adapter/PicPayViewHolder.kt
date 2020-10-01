package com.lucas.desafioandroid.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.helper.HelperView.callImagePicaso
import com.lucas.desafioandroid.model.Users

class PicPayViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBindPicPay(resultList: Users) {
        val ivPicture: ImageView = itemView.findViewById(R.id.iv_picture)
        callImagePicaso(resultList, ivPicture)

        val tvUserName: TextView = itemView.findViewById(R.id.tv_username)
        tvUserName.text = resultList.username

        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        tvName.text = resultList.name

    }
}
