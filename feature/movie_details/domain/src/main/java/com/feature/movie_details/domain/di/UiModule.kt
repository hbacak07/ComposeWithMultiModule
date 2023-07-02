package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repo.TvShowDetailsRepo
import com.feature.movie_details.domain.use_cases.GetTvShowDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideGetTvShowsDetailsUseCase(tvShowDetailsRepo: TvShowDetailsRepo):GetTvShowDetailsUseCase{
        return GetTvShowDetailsUseCase(tvShowDetailsRepo)
    }
}