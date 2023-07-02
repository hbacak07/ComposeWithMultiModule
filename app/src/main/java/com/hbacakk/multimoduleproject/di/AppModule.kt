package com.hbacakk.multimoduleproject.di

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.TvShowDetailsApi
import com.hbacakk.multimoduleproject.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideNavigationProvider(movieApi: MovieApi,tvShowDetailsApi: TvShowDetailsApi):NavigationProvider{
        return NavigationProvider(movieApi,tvShowDetailsApi)
    }
}