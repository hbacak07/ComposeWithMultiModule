package com.feature.movie_details.data.mappers

import com.core.network.model.TvShowDetailsResponse
import com.feature.movie_details.domain.model.TvShowDetails

fun TvShowDetailsResponse.toDomain(): TvShowDetails {
    return TvShowDetails(
        country = this.tvShow.country,
        description = this.tvShow.description,
        description_source = this.tvShow.description_source,
        genres = this.tvShow.genres,
        id = this.tvShow.id,
        image_path = this.tvShow.image_path,
        image_thumbnail_path = this.tvShow.image_thumbnail_path,
        name = this.tvShow.name,
        network = this.tvShow.network,
        permalink = this.tvShow.permalink,
        pictures = this.tvShow.pictures,
        rating = this.tvShow.rating,
        rating_count = this.tvShow.rating_count,
        runtime = this.tvShow.runtime,
        start_date = this.tvShow.start_date,
        status = this.tvShow.status,
        url = this.tvShow.url
    )
}