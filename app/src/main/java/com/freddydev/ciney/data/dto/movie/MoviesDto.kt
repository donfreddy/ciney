package com.freddydev.ciney.data.dto.movie

import com.freddydev.ciney.domain.model.movie.Movies

data class MoviesDto(
  val page: Int,
  val total_results: Int,
  val total_pages: Int,
  val results: List<MovieDto>
)

fun MoviesDto.toMovies(): Movies {
  return Movies(movies = results.map { it.toMovie() })
}