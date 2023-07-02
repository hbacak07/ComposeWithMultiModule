package com.core.network

import com.core.network.model.MovieListResponse
import com.core.network.model.TvShowDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://www.episodate.com/api/most-popular?page=1
    @GET("most-popular")
    suspend fun getTvShowList(
        @Query("page") page: Int
    ): MovieListResponse

    // https://www.episodate.com/api/show-details?q=arrow
    @GET("show-details")
    suspend fun getTvShowDetails(
        @Query("q") query: String
    ): TvShowDetailsResponse


}