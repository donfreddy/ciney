package com.freddydev.ciney.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freddydev.ciney.domain.usecase.movie.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
  private val getNowPlayingMovies: GetNowPlayingMoviesUseCase
) : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is Movie Screen"
  }
  val text: LiveData<String> = _text

  fun getMovies() = liveData {
    val movieList = getNowPlayingMovies.execute()
    println("########################## MovieViewModel: ${movieList.size}")
    emit(movieList)
  }
}

