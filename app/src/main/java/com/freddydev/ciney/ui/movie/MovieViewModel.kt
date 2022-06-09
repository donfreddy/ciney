package com.freddydev.ciney.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
import com.freddydev.ciney.util.Constants.DEFAULT_PAGE
import com.freddydev.ciney.util.Constants.HTTP_EXCEPT_MSG
import com.freddydev.ciney.util.EnumCategory
import com.freddydev.ciney.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
  private val getMovies: GetMoviesUseCase
) : ViewModel() {

  // All states
  private val _popularMoviesState = mutableStateOf(MovieState())
  val popularMoviesState: State<MovieState> = _popularMoviesState

  init {
    println("### Start MovieViewModel")
    getPopularMovies()
  }

  /**
   * Get popular movies.
   */
  private fun getPopularMovies() {
    getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = EnumCategory.POPULAR.value,
        page = DEFAULT_PAGE
      )
    )
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _popularMoviesState.value = MovieState(isLoading = true)
          }
          is Resource.Success -> {
            _popularMoviesState.value = MovieState(movies = result.data)
          }
          is Resource.Error -> {}
        }
      }.launchIn(viewModelScope)
  }

  /**
   * Get now playing movies.
   */
  fun getNowPlayingMovies() {
    getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = EnumCategory.NOW_PLAYING.value,
        page = DEFAULT_PAGE
      )
    )
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {}
          is Resource.Success -> {}
          is Resource.Error -> {}
        }
      }.launchIn(viewModelScope)
  }
}

