package com.hbacakk.multimoduleproject.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.TvShowDetailsApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val tvShowDetailsApi: TvShowDetailsApi
)