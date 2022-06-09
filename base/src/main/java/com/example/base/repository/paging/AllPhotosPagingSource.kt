package com.example.base.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.remote.data.AllPhotosResponse
import com.example.base.remote.data.AllPhotosResponseItem
import com.example.base.ui.AllPhotosData
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AllPhotosPagingSource @Inject constructor(
    private val allPhotosWebService: AllPhotosWebService
) : PagingSource<Int, AllPhotosData>() {
    override fun getRefreshKey(state: PagingState<Int, AllPhotosData>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AllPhotosData> {
        val page = params.key ?: 1

        return try {
            val response = allPhotosWebService.getAllPhotos(page = page, per_page = params.loadSize)

            //you have to convert your response to list here because the paging 3 library has to
            // receive your response as a list so that it will assign a page value to a specific list
            //e.g 1st set of list must have page value as 1, next set page value as 2 etc
            val responseToList : MutableList<AllPhotosData> = mutableListOf<AllPhotosData>()

            val receivedResponse : List<AllPhotosData>? = response.body()?.map {
                AllPhotosData(
                    id = it.id,
                    images = it.urls.regular,
                    likes = it.likes,
                    user = "${it.user.first_name} ${it.user.last_name}"
                )
            }

            if (receivedResponse != null) {
                responseToList.addAll(receivedResponse)
            }

            LoadResult.Page(
                data = responseToList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (responseToList.isEmpty()) null else page + 1
            )
        }catch (err : IOException){
            return LoadResult.Error(err)
        }catch (err : HttpException){
            return LoadResult.Error(err)
        }
    }
}