package com.example.base.repository

import com.example.base.remote.api.AllPhotosWebService
import com.example.base.ui.AllPhotosData
import retrofit2.Response
import javax.inject.Inject

class AllPhotosRepositoryImpl @Inject constructor(
    allPhotosWebService: AllPhotosWebService
) : AllPhotosRepository {
    override suspend fun getAllPhotos(
        page: Int,
        per_page: String,
        order_by: String
    ): Response<AllPhotosData> {
        TODO("Not yet implemented")
    }
}