package com.feature.movie.domain.repo

import com.feature.movie.domain.model.TvShow

interface MovieRepository {
    suspend fun getMovieList(page:Int):List<TvShow>
}