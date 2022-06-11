package com.freddydev.ciney.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddydev.ciney.domain.usecase.movie.GetMovieDetailUseCase
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
  private val getMovies: GetMoviesUseCase,
  private val getMovieDetail: GetMovieDetailUseCase
) : ViewModel() {

  private val _popularMoviesState = mutableStateOf(MovieState())
  val popularMoviesState: State<MovieState> = _popularMoviesState

  private val _nowPlayingMoviesState = mutableStateOf(MovieState())
  val nowPlayingMoviesState: State<MovieState> = _nowPlayingMoviesState

  private val _upcomingMoviesState = mutableStateOf(MovieState())
  val upcomingMoviesState: State<MovieState> = _upcomingMoviesState

  private val _topRatedMoviesState = mutableStateOf(MovieState())
  val topRatedMoviesState: State<MovieState> = _topRatedMoviesState

  // movie detail
  private val _movieDetailState = mutableStateOf(MovieDetailState())
  val movieDetailState: State<MovieDetailState> = _movieDetailState

  init {
    println("### Start MovieViewModel")
    getPopularMovies()
    getNowPlayingMovies()
    getUpcomingMovies()
    getTopRatedMovies()
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
  private fun getNowPlayingMovies() {
    getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = EnumCategory.NOW_PLAYING.value,
        page = DEFAULT_PAGE
      )
    )
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _nowPlayingMoviesState.value = MovieState(isLoading = true)
          }
          is Resource.Success -> {
            _nowPlayingMoviesState.value = MovieState(movies = result.data)
          }
          is Resource.Error -> {
            _nowPlayingMoviesState.value = MovieState(error = "${result.message} $HTTP_EXCEPT_MSG")
          }
        }
      }.launchIn(viewModelScope)
  }


  /**
   * Get upcoming movies.
   */
  private fun getUpcomingMovies(movieId: Int = 0) {
    getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = EnumCategory.UPCOMING.value,
        page = DEFAULT_PAGE
      )
    )
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _upcomingMoviesState.value = MovieState(isLoading = true)
          }
          is Resource.Success -> {
            _upcomingMoviesState.value = MovieState(movies = result.data)
          }
          is Resource.Error -> {
            _upcomingMoviesState.value = MovieState(error = "${result.message} $HTTP_EXCEPT_MSG")
          }
        }
      }.launchIn(viewModelScope)
  }

  /**
   * Get top rated movies.
   */
  private fun getTopRatedMovies() {
    getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = EnumCategory.TOP_RATED.value,
        page = DEFAULT_PAGE
      )
    )
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _topRatedMoviesState.value = MovieState(isLoading = true)
          }
          is Resource.Success -> {
            _topRatedMoviesState.value = MovieState(movies = result.data)
          }
          is Resource.Error -> {
            _topRatedMoviesState.value = MovieState(error = "${result.message} $HTTP_EXCEPT_MSG")
          }
        }
      }.launchIn(viewModelScope)
  }

  /**
   * Get movie detail.
   */
  fun getMovieDetail(movieId: Int) {
    getMovieDetail.execute(params = GetMovieDetailUseCase.Params(movieId = movieId))
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _movieDetailState.value = MovieDetailState(isLoading = true)
          }
          is Resource.Success -> {
            _movieDetailState.value = MovieDetailState(movie = result.data)
          }
          is Resource.Error -> {
            _movieDetailState.value = MovieDetailState(error = "${result.message} $HTTP_EXCEPT_MSG")
          }
        }
      }.launchIn(viewModelScope)
  }
}
