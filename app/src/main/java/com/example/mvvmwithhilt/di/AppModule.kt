package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.BuildConfig
import com.example.mvvmwithhilt.api.AllRestEnds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val BASE_URL = "https://simplifiedcoding.net/"

    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit): AllRestEnds {
        return retrofit.create(AllRestEnds::class.java)
    }

    @Singleton
    @Provides
    fun getInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .also {
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = (HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(logging)
                }
            }.build()
    }


}