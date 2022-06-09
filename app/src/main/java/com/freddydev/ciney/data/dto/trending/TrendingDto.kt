package com.freddydev.ciney.data.dto.trending

import com.freddydev.ciney.domain.model.trending.Trending

data class TrendingDto(
  val adult: Boolean,
  val backdrop_path: String,
  val first_air_date: String,
  val genre_ids: List<Int>,
  val id: Int,
  val media_type: String,
  val name: String,
  val origin_country: List<String>,
  val original_language: String,
  val original_name: String,
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

fun TrendingDto.toTrending(): Trending {
  return Trending(
    id = id,
    name = name,
    title = title,
    media_type = media_type,
    backdrop_path = backdrop_path,
    first_air_date = first_air_date,
    original_language = original_language,
    original_name = original_name,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    vote_count = vote_count
  )
}