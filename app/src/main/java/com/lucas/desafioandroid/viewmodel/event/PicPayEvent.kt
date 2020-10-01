package com.lucas.desafioandroid.viewmodel.event

import com.lucas.desafioandroid.model.User

sealed class PicPayEvent {
    data class LoadingVisible(val visibility: Int) : PicPayEvent()
    data class LoadingGone(val visibility: Int) : PicPayEvent()
    data class Success(val getListPicPay: List<User>) : PicPayEvent()
    data class ListError(val error: String) : PicPayEvent()

}
