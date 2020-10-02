package com.lucas.desafioandroid.user.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.desafioandroid.user.usecase.PicPayUseCase
import com.lucas.desafioandroid.user.viewmodel.state.PicPayState
import kotlinx.coroutines.launch
import java.lang.Exception

class PicPayViewModel(private val useCase: PicPayUseCase) : ViewModel() {

    private val state: MutableLiveData<PicPayState> = MutableLiveData()
    val stateView: LiveData<PicPayState> = state

    fun getList(){
        state.value = PicPayState.LoadingVisible(View.VISIBLE)
        viewModelScope.launch {
            state.value = PicPayState.LoadingVisible(View.GONE)
            try {
                val listUsers = useCase.getListUsers()
                state.value = PicPayState.Success(listUsers)
                state.value = PicPayState.LoadingGone(View.GONE)
            } catch (ex: Exception){
                ex.printStackTrace()
                state.value = PicPayState.ListError(ex.message.toString())
            }
        }
    }
}