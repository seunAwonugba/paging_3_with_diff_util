package com.example.base.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.repository.paging.AllPhotosPagingSource
import com.example.base.ui.AllPhotosData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllPhotosRepositoryImpl @Inject constructor(
    private val allPhotosWebService: AllPhotosWebService
) : AllPhotosRepository {
    override suspend fun getAllPhotos(
        page: Int,
        per_page: String,
        order_by: String
    ): Flow<PagingData<AllPhotosData>> {

        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {AllPhotosPagingSource(allPhotosWebService = allPhotosWebService)}
        ).flow
    }

}