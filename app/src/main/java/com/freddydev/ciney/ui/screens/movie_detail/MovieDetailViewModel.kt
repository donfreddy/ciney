package com.freddydev.ciney.ui.screens.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddydev.ciney.domain.usecase.movie.get_movie.GetMovieUseCase
import com.freddydev.ciney.ui.common.Constants
import com.freddydev.ciney.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
  private val getMovie: GetMovieUseCase,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _movieDetailState = mutableStateOf(MovieDetailState())
  val movieDetailState: State<MovieDetailState> = _movieDetailState

  init {
    savedStateHandle.get<Int>(Constants.PARAM_MOVIE_ID)?.let { movieId ->
      println("### Movie ID: $movieId")
      // getMovieDetail(movieId)
    }
  }

  /**
   * Get movie detail.
   */
  private fun getMovieDetail(movieId: Int) {
    getMovie.execute(params = GetMovieUseCase.Params(movieId = movieId))
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _movieDetailState.value = MovieDetailState(isLoading = true)
          }
          is Resource.Success -> {
            _movieDetailState.value = MovieDetailState(movie = result.data)
          }
          is Resource.Error -> {
            _movieDetailState.value =
              MovieDetailState(error = "${result.message} ?: ${Constants.HTTP_EXCEPT_MSG}")
          }
        }
      }.launchIn(viewModelScope)
  }

  /**
   * Get similar movies.
   */
  // private fun getSimilarMovies(movieId: Int)_{}
}