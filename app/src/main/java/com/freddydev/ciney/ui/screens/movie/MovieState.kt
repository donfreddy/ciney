package com.freddydev.ciney.ui.screens.movie

import com.freddydev.ciney.domain.model.movie.Movie

data class MovieState(
  val isLoading: Boolean = false,
  val movies: List<Movie> ?= emptyList(),
  val error: String = ""
)