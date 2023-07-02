package com.core.network.dataprovides

import com.core.network.ApiService
import javax.inject.Inject

class MovieDataProviders @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovieList(page: Int) = apiService.getTvShowList(page)
    suspend fun getMovieDetails(query: String) = apiService.getTvShowDetails(query)
}