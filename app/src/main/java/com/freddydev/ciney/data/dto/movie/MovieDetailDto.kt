package com.freddydev.ciney.data.dto.movie

import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.orther.Genre
import com.freddydev.ciney.domain.model.orther.ProductionCompany
import com.freddydev.ciney.domain.model.orther.ProductionCountry
import com.freddydev.ciney.domain.model.orther.SpokenLanguage

data class MovieDetailDto(
  val adult: Boolean,
  val backdrop_path: String,
  val belongs_to_collection: Any,
  val budget: Int,
  val genres: List<Genre>,
  val homepage: String,
  val id: Int,
  val imdb_id: String,
  val original_language: String,
  val original_title: String,
  val overview: String,
  val popularity: Double,
  val poster_path: String,
  val production_companies: List<ProductionCompany>,
  val production_countries: List<ProductionCountry>,
  val release_date: String,
  val revenue: Int,
  val runtime: Int,
  val spoken_languages: List<SpokenLanguage>,
  val status: String,
  val tagline: String,
  val title: String,
  val video: Boolean,
  val vote_average: Double,
  val vote_count: Int
)

fun MovieDetailDto.toMovieDetail() = MovieDetail(
  id = id,
  title = title,
  backdrop_path = backdrop_path,
  budget = budget,
  genres = genres,
  homepage = homepage,
  original_language = original_language,
  original_title = original_title,
  overview = overview,
  popularity = popularity,
  poster_path = poster_path,
  production_companies = production_companies,
  production_countries = production_countries,
  release_date = release_date,
  revenue = revenue,
  runtime = runtime,
  spoken_languages = spoken_languages,
  status = status,
  tagline = tagline,
  vote_average = vote_average,
  vote_count = vote_count
)