package com.feature.movie_details.data.di

import com.core.network.dataprovides.MovieDataProviders
import com.feature.movie_details.data.repo.TvShowDetailsRepoImpl
import com.feature.movie_details.domain.repo.TvShowDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideTvShowDetailsRepo(movieDataProviders: MovieDataProviders):TvShowDetailsRepo{
        return TvShowDetailsRepoImpl(movieDataProviders)
    }
}