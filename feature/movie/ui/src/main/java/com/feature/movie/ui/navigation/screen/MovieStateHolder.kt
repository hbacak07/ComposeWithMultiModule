package com.feature.movie.ui.navigation.screen

import com.feature.movie.domain.model.TvShow

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<TvShow>? = null,
    val message:String = ""
)
