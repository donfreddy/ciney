package com.freddydev.ciney.ui.movie

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail

data class MovieState(
  val isLoading: Boolean = false,
  val movies: List<Movie> ?= emptyList(),
  val error: String = ""
)