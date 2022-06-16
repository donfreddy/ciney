package com.freddydev.ciney.ui.screens.movie_detail

import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.video.Video

data class MovieDetailState(
  val isLoading: Boolean = false,
  val movie: MovieDetail? = null,
  val videos: List<Video>? = emptyList(),
  val error: String = ""
)

data class MovieVideoState(
  val isLoading: Boolean = false,
  val videos: List<Video> = emptyList(),
  val error: String = ""
)
