package com.feature.movie.data.mapper

import com.core.network.model.MovieListResponse
import com.feature.movie.domain.model.TvShow

fun MovieListResponse.toDomainMovieList(): List<TvShow> {
    return this.tv_shows.map {
        TvShow(
            it.country,
            it.id,
            it.image_thumbnail_path,
            it.name,
            it.network,
            it.permalink,
            it.start_date,
            it.status
        )
    }
}