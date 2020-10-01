package com.lucas.desafioandroid.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.desafioandroid.usecase.PicPayUseCase
import com.lucas.desafioandroid.viewmodel.event.PicPayEvent
import kotlinx.coroutines.launch
import java.lang.Exception

class PicPayViewModel(private var useCase: PicPayUseCase) : ViewModel() {

    private val event: MutableLiveData<PicPayEvent> = MutableLiveData()
    val eventView: LiveData<PicPayEvent> = event

    fun getList(){
        viewModelScope.launch {
            event.value = PicPayEvent.LoadingVisible(View.GONE)
            try {
                val listUsers = useCase.getListUsers()
                event.value = PicPayEvent.Success(listUsers)
                event.value = PicPayEvent.LoadingGone(View.GONE)
            } catch (ex: Exception){
                ex.printStackTrace()
                event.value = PicPayEvent.ListError(ex.message.toString())
            }
        }
    }
}