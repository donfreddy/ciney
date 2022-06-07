package com.freddydev.ciney.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.usecase.movie.GetLatestMovieUseCase
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
import com.freddydev.ciney.util.Constants.HTTP_EXCEPT_MSG
import com.freddydev.ciney.util.Constants.NOW_PLAYING
import com.freddydev.ciney.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
  private val getLatestMovie: GetLatestMovieUseCase,
  private val getMovies: GetMoviesUseCase
) : ViewModel() {
  // Default number page to load movies
  private val numberPage = 1

  private val _latestMovieState = mutableStateOf(MovieDetailState())
  val latestMovieState: State<MovieDetailState> = _latestMovieState

  init {
    println("### Start MovieViewModel")
    getLatestMovie()
  }

  /**
   * Get latest movie
   */
  private fun getLatestMovie() {
    getLatestMovie.execute().onEach { result ->
      when (result) {
        is Resource.Loading -> {
          _latestMovieState.value = MovieDetailState(isLoading = true)
        }
        is Resource.Success -> {
          println("### Successful get latest movie from api 🥳")
          _latestMovieState.value = MovieDetailState(movie = result.data)
        }
        is Resource.Error -> {
          _latestMovieState.value = MovieDetailState(error = result.message ?: HTTP_EXCEPT_MSG)
        }
      }
    }.launchIn(viewModelScope)
  }

  /**
   * Get popular movies.
   */
  fun getPopularMovies() {
    getMovies.execute(params = GetMoviesUseCase.Params(category = NOW_PLAYING, page = numberPage))
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {}
          is Resource.Success -> {}
          is Resource.Error -> {}
        }
      }.launchIn(viewModelScope)
  }

  /**
   * Get now playing movies.
   */
  fun getNowPlayingMovies() {
    getMovies.execute(params = GetMoviesUseCase.Params(category = NOW_PLAYING, page = numberPage))
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {}
          is Resource.Success -> {}
          is Resource.Error -> {}
        }
      }.launchIn(viewModelScope)
  }
}

