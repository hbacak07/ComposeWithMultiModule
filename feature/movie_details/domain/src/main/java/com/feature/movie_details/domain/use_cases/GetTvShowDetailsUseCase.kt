package com.feature.movie_details.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie_details.domain.model.TvShowDetails
import com.feature.movie_details.domain.repo.TvShowDetailsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetTvShowDetailsUseCase @Inject constructor(private val tvShowDetailsRepo: TvShowDetailsRepo) {
    operator fun invoke(query: String): Flow<UiEvent<TvShowDetails>> = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(tvShowDetailsRepo.getMovieDetails(query)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}