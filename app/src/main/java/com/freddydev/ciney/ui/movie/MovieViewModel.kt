package com.freddydev.ciney.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
  private val getMovies: GetMoviesUseCase
) : ViewModel() {

  // Default number page to load movies
  private val numberPage = 1



  init {
    println("### Start MovieViewModel")
    getNowPlaying()
  }

  private val _text = MutableLiveData<String>().apply {
    value = "This is Movie Screen"
  }
  val text: LiveData<String> = _text

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
    println("### MovieViewModel: ${movieList.size}")
    emit(movieList)
  }
}

