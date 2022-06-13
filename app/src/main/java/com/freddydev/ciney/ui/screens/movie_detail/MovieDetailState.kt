package com.freddydev.ciney.ui.screens.movie_detail

import com.freddydev.ciney.domain.model.movie.MovieDetail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val movie: MovieDetail? = null,
  val error: String = ""
)
