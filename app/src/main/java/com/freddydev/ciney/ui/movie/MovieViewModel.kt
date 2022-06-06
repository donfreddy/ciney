package com.freddydev.ciney.ui.movie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.usecase.movie.GetLatestMovieUseCase
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
  val getLatestMovie: GetLatestMovieUseCase,
  private val getMovies: GetMoviesUseCase
) : ViewModel() {
  // Default number page to load movies
  private val numberPage = 1

  private var latestMovie: State<MovieDetail?> = mutableStateOf(value = null)

  init {
    println("### Start MovieViewModel")
    // getNowPlaying()
//    getLatestMovie()

    viewModelScope.launch {
      var n = getLatestMovie.execute()
      // latestMovie.value.postValue(n)
    }
  }

  private val _text = MutableLiveData<String>().apply {
    value = "This is Movie Screen"
  }
  val text: LiveData<String> = _text

  /**
   * Get latest movie
   */
//  fun getLatestMovie() = liveData {
//    emit()
//  }

  /**
   * Get now playing movies.
   */
  fun getNowPlaying() = liveData {
    val movieList = getMovies.execute(
      params = GetMoviesUseCase.Params(
        category = "now_playing",
        page = numberPage
      )
    )
    // println("### MovieViewModel: ${movieList}")
    emit(movieList)
  }
}

