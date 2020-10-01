package com.lucas.desafioandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users(
    val id: Int,
    val img: String,
    val name: String,
    val username: String
) : Parcelable