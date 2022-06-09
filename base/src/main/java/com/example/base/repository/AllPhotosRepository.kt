package com.example.base.repository

import androidx.paging.PagingData
import com.example.base.ui.AllPhotosData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface AllPhotosRepository {
    suspend fun getAllPhotos(
        page : Int,
        per_page : String,
        order_by : String
    ) : Flow<PagingData<AllPhotosData>>
}


