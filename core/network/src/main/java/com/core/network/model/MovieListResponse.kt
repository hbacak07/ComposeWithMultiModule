package com.core.network.model

data class MovieListResponse(
    val page: Int,
    val pages: Int,
    val total: String,
    val tv_shows: List<TvShow>
)