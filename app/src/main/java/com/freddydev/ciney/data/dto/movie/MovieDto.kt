package com.freddydev.ciney.data.dto.movie

import com.freddydev.ciney.domain.model.movie.Movie

data class MovieDto(
  val id: Int,
  val adult: Boolean,
  val backdrop_path: String,
  val genre_ids: List<String>? = ArrayList(),
  val original_language: String,
  val original_title: String,
  val overview: String,
  val popularity: Double,
  val poster_path: String,
  val release_date: String,
  val title: String,
  val video: Boolean,
  val vote_average: Double,
  val vote_count: Int
)

fun MovieDto.toMovie(): Movie {
  return Movie(
    id = id,
    backdrop_path = backdrop_path,
    original_title = original_title,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    vote_average = vote_average,
    vote_count = vote_count
  )
}