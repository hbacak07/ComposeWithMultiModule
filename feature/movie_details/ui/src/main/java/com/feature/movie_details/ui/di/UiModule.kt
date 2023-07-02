package com.feature.movie_details.ui.di

import com.feature.movie_details.ui.navigation.TvShowDetailsApi
import com.feature.movie_details.ui.navigation.TvShowDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideTvShowDetailsApi():TvShowDetailsApi{
        return TvShowDetailsApiImpl()
    }
}