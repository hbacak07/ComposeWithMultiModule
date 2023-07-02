package com.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_details.domain.use_cases.GetTvShowDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    private val getTvShowDetailsUseCase: GetTvShowDetailsUseCase,
        savedStateHandle: SavedStateHandle
    ) :
    ViewModel() {

    private val _tvShowDetails = mutableStateOf(TvShowDetailsStateHolder())
    val tvShowDetails: State<TvShowDetailsStateHolder> get() = _tvShowDetails

    init {
        savedStateHandle.getLiveData<String>("id").observeForever{
            it?.let {
                getTvShowDetails(it)
            }
        }
    }

    fun getTvShowDetails(id: String) {
        getTvShowDetailsUseCase(id).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _tvShowDetails.value = TvShowDetailsStateHolder(isLoading = true)
                }
                is UiEvent.Error -> {
                    _tvShowDetails.value = TvShowDetailsStateHolder(error = it.message.toString())
                }
                is UiEvent.Success -> {
                    _tvShowDetails.value = TvShowDetailsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}