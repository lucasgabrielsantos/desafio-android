package com.lucas.desafioandroid.user.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val img: String,
    val name: String,
    val username: String
) : Parcelable