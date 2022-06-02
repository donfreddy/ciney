package com.freddydev.ciney.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.freddydev.ciney.domain.usecase.movie.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
class MovieViewModel(private val getNowPlayingMovies: GetNowPlayingMoviesUseCase) :
  ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is Movie Screen"
  }
  val text: LiveData<String> = _text

//  fun getNowPlayingMovies() = liveData {
//    val movieList = getNowPlayingMovies.execute()
//    emit(movieList)
//  }
}

