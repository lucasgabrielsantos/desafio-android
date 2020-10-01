package com.lucas.desafioandroid.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.helper.HelperView.callImagePicasso
import com.lucas.desafioandroid.model.User

class PicPayViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBindPicPay(user: User) {
        val ivPicture: ImageView = itemView.findViewById(R.id.ivPicture)
        callImagePicasso(user, ivPicture)

        val tvUserName: TextView = itemView.findViewById(R.id.tvUsername)
        tvUserName.text = user.username

        val tvName: TextView = itemView.findViewById(R.id.tvName)
        tvName.text = user.name

    }
}
