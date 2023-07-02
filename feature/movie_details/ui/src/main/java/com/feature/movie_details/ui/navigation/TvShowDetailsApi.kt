package com.feature.movie_details.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface TvShowDetailsApi : FeatureApi {

}

class TvShowDetailsApiImpl : TvShowDetailsApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalTvShowDetailsApi.registerGraph(navController,navGraphBuilder)
    }
}