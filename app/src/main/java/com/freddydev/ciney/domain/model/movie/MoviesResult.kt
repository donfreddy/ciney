package com.freddydev.ciney.domain.model.movie

import com.freddydev.ciney.domain.model.movie.Movie

data class MoviesResult(
  val page: Int,
  val movies: List<Movie>,
  val total_pages: Int,
  val total_results: Int
)