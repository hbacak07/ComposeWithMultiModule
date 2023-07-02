package com.feature.movie.data.repo

import com.core.network.dataprovides.MovieDataProviders
import com.feature.movie.data.mapper.toDomainMovieList
import com.feature.movie.domain.model.TvShow
import com.feature.movie.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val movieDataProivers: MovieDataProviders) :
    MovieRepository {
    override suspend fun getMovieList(page: Int): List<TvShow> {
        return movieDataProivers.getMovieList(page).toDomainMovieList()
    }
}