package com.example.base

import com.example.base.Constants.GET_ALL_PHOTOS_END_POINT
import com.example.base.remote.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AllPhotosWebService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(GET_ALL_PHOTOS_END_POINT)
    suspend fun getAllPhotos(
        @Query("page") page: Int,
        @Query("per_page") per_page : Int,
        @Query("order_by") order_by : String
    ) : Response<ApiResponse>
}