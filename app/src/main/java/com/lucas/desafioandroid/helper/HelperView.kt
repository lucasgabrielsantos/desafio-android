package com.lucas.desafioandroid.helper

import android.widget.ImageView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.model.Users
import com.squareup.picasso.Picasso

object HelperView {

     fun callImagePicaso(
         resultList: Users,
         ivPicture: ImageView
    ) {
        Picasso.get()
            .load(resultList.img)
            .error(R.drawable.ic_round_account_circle)
            .into(ivPicture)
    }


}