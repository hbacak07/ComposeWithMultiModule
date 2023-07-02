package com.feature.movie_details.domain.repo

import com.feature.movie_details.domain.model.TvShowDetails

interface TvShowDetailsRepo {
    suspend fun getMovieDetails(query:String) : TvShowDetails
}