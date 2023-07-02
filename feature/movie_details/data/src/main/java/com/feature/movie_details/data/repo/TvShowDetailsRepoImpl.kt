package com.feature.movie_details.data.repo

import com.core.network.dataprovides.MovieDataProviders
import com.feature.movie_details.data.mappers.toDomain
import com.feature.movie_details.domain.model.TvShowDetails
import com.feature.movie_details.domain.repo.TvShowDetailsRepo
import javax.inject.Inject


class TvShowDetailsRepoImpl @Inject constructor(private val movieDataProviders: MovieDataProviders) : TvShowDetailsRepo {
    override suspend fun getMovieDetails(query: String): TvShowDetails {
        return movieDataProviders.getMovieDetails(query).toDomain()
    }
}