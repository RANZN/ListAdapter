package com.example.listadapter.app.persentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.app.domain.use_cases.UseCases
import com.example.listadapter.common.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val useCases: UseCases) : ViewModel() {

    private val _data = MutableLiveData<Resource<ResponseModel>>()
    val data = _data as LiveData<Resource<ResponseModel>>

    init {
        viewModelScope.launch {
            useCases.getData().collect {
                _data.postValue(it)
            }
        }
    }
}