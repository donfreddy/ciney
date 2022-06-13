package com.freddydev.ciney.data.dto.movie

import com.freddydev.ciney.domain.model.movie.MoviesResult

data class MoviesResultDto(
  val page: Int,
  val total_results: Int,
  val total_pages: Int,
  val results: List<MovieDto>
)

fun MoviesResultDto.toMovies(): MoviesResult {
  return MoviesResult(movies = results.map { it.toMovie() })
}