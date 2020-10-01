package com.lucas.desafioandroid.viewmodel.state

import com.lucas.desafioandroid.model.User

sealed class PicPayState {
    data class LoadingVisible(val visibility: Int) : PicPayState()
    data class LoadingGone(val visibility: Int) : PicPayState()
    data class Success(val getListPicPay: List<User>) : PicPayState()
    data class ListError(val error: String) : PicPayState()

}
