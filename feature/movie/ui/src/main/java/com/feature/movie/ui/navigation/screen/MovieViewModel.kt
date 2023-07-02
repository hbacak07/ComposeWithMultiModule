package com.feature.movie.ui.navigation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) :
    ViewModel() {
    private val _movieList = mutableStateOf(MovieStateHolder())
    val movieList: State<MovieStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    fun setLoadPage(page: Int) {
        _query.value = page.toString()
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(1)
            }
        }
    }

    fun getMovieList(
        page: Int
    ) = viewModelScope.launch {
        getMovieListUseCase(page).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieList.value = MovieStateHolder(isLoading = true)
                }
                is UiEvent.Success -> {
                    _movieList.value = MovieStateHolder(data = it.data)
                }
                is UiEvent.Error -> {
                    _movieList.value = MovieStateHolder(message = it.message.toString())
                }
            }
        }.launchIn(
            viewModelScope
        )
    }
}
