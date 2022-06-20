package com.freddydev.ciney.ui.screens.media_videos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddydev.ciney.domain.use_case.movie.get_movie_videos.GetMovieVideosUseCase
import com.freddydev.ciney.ui.common.Constants
import com.freddydev.ciney.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MediaVideoViewModel @Inject constructor(
  private val getMovieVideos: GetMovieVideosUseCase,
  savedStateHandle: SavedStateHandle
) : ViewModel() {
  // Trailers state
  private val _trailersState = mutableStateOf(VideoState())
  val trailersState: State<VideoState> = _trailersState

  init {
    savedStateHandle.get<String>("mediaId")?.let { mediaId ->
      getMovieVideos(movieId = mediaId.toInt())
    }
  }

  /**
   * Get movie videos.
   */
  private fun getMovieVideos(movieId: Int) {
    getMovieVideos.execute(params = GetMovieVideosUseCase.Params(movieId = movieId))
      .onEach { result ->
        when (result) {
          is Resource.Loading -> {
            _trailersState.value = VideoState(isLoading = true)
          }
          is Resource.Success -> {
            println("### Movie Videos Success state")
            println(result.data)
            _trailersState.value = VideoState(videos = result.data ?: emptyList())
          }
          is Resource.Error -> {
            _trailersState.value =
              VideoState(error = "${result.message} ?: ${Constants.HTTP_EXCEPT_MSG}")
          }
        }
      }.launchIn(viewModelScope)
  }
}