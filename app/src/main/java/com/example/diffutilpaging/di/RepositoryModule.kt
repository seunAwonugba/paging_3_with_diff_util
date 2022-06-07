package com.example.diffutilpaging.di

import com.example.base.remote.api.AllPhotosWebService
import com.example.base.remote.api.SinglePhotosWebService
import com.example.base.repository.AllPhotosRepository
import com.example.base.repository.AllPhotosRepositoryImpl
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
    fun provideAllPhotosWebService(retrofit: Retrofit) : AllPhotosWebService {
        return retrofit.create()
    }

    @Singleton
    @Provides
    fun provideSinglePhotosWebService(retrofit: Retrofit) : SinglePhotosWebService {
        return retrofit.create()
    }

    @Singleton
    @Provides
    fun provideAllPhotosWebserviceToRepository(
        allPhotosWebService: AllPhotosWebService
    ) : AllPhotosRepository = AllPhotosRepositoryImpl(allPhotosWebService)
}