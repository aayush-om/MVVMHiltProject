package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.api.AllRestEnds
import com.example.mvvmwithhilt.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getModule(apiInterface: AllRestEnds): MarvelRepository {
        return MarvelRepository(apiInterface)
    }
}