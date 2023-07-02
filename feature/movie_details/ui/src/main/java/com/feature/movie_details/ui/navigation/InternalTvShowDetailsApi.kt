package com.feature.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.TvShowDetailsFeature
import com.core.feature_api.FeatureApi
import com.feature.movie_details.ui.screen.TvShowDetailsScreen
import com.feature.movie_details.ui.screen.TvShowDetailsViewModel

object InternalTvShowDetailsApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = TvShowDetailsFeature.TvShowDetailsScreenRoute,
            route = TvShowDetailsFeature.nestedRoute
        ) {
            composable(TvShowDetailsFeature.TvShowDetailsScreenRoute) {
                val id = it.arguments?.getString("id")
                val viewModel = hiltViewModel<TvShowDetailsViewModel>()
                TvShowDetailsScreen(id = id.toString(), viewModel = viewModel)
            }
        }
    }
}