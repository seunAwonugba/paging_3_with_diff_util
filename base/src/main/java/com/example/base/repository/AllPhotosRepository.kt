package com.example.base.repository

import com.example.base.ui.AllPhotosData
import retrofit2.Response

interface AllPhotosRepository {
    suspend fun getAllPhotos(
        page : Int,
        per_page : String,
        order_by : String
    ) : Response<AllPhotosData>
}