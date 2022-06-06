package com.example.diffutilpaging.di

import com.example.base.AllPhotosWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAllPhotosWebService(retrofit: Retrofit) : AllPhotosWebService{
        return retrofit.create()
    }
}