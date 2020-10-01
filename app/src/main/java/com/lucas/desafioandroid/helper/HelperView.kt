package com.lucas.desafioandroid.helper

import android.widget.ImageView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.model.User
import com.squareup.picasso.Picasso

object HelperView {

    fun callImagePicasso(resultList: User, ivPicture: ImageView) {
        Picasso.get()
            .load(resultList.img)
            .error(R.drawable.ic_round_account_circle)
            .into(ivPicture)
    }
}