package com.example.mvvmwithhilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithhilt.model.ResMarvelModel
import com.example.mvvmwithhilt.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor(
    private val marvelRepository: MarvelRepository,
) : ViewModel() {

    private val _marvelResponse = MutableLiveData<ResMarvelModel>()
    val marvelResponse: LiveData<ResMarvelModel>
        get() = _marvelResponse

    fun getData(){
        viewModelScope.launch {
           _marvelResponse.postValue(marvelRepository.getMarvelList())
        }
    }

}
