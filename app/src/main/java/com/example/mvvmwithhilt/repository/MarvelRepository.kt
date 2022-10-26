package com.example.mvvmwithhilt.repository

import com.example.mvvmwithhilt.api.AllRestEnds
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val apiInterface: AllRestEnds
)
 {
    suspend fun getMarvelList() = apiInterface.getMarvelList()
}
