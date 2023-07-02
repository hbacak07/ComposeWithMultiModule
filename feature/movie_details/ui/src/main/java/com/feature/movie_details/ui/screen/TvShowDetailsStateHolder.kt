package com.feature.movie_details.ui.screen

import com.feature.movie_details.domain.model.TvShowDetails

data class TvShowDetailsStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: TvShowDetails? = null
)
