package com.freddydev.ciney.domain.model.tvshow

data class TvShow(
  val id: Int,
  val backdrop_path: String,
  val first_air_date: String,
  val genre_ids: List<String>,
  val name: String,
  val origin_country: List<String>,
  val original_language: String,
  val original_name: String,
  val overview: String,
  val popularity: Double,
  val poster_path: String,
  val vote_average: Double,
  val vote_count: Int
)