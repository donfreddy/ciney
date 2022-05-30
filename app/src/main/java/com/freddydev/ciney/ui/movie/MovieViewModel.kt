package com.freddydev.ciney.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freddydev.ciney.domain.usecase.movie.GetNowPlayingMoviesUseCase

class MovieViewModel(private val getNowPlayingMovies: GetNowPlayingMoviesUseCase) : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is Movie Screen"
  }
  val text: LiveData<String> = _text

//  fun getNowPlayingMovies() = liveData {
//    val movieList = getNowPlayingMovies.execute()
//    emit(movieList)
//  }
}

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(
  private val getNowPlayingMovies: GetNowPlayingMoviesUseCase
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
      return MovieViewModel(getNowPlayingMovies = getNowPlayingMovies) as T
    }
    throw IllegalArgumentException("Unknown View Model Class")
  }
}