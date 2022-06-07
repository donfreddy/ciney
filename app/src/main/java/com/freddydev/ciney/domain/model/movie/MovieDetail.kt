package com.freddydev.ciney.domain.model.movie

import com.freddydev.ciney.domain.model.orther.Genre
import com.freddydev.ciney.domain.model.orther.ProductionCompany
import com.freddydev.ciney.domain.model.orther.ProductionCountry
import com.freddydev.ciney.domain.model.orther.SpokenLanguage

data class MovieDetail(
  val id: Int,
  val title: String,
  val original_title: String,
  val backdrop_path: String?,
  val budget: Int,
  val genres: List<Genre>,
  val homepage: String,
  val original_language: String,
  val overview: String,
  val popularity: Double,
  val poster_path: String?,
  val production_companies: List<ProductionCompany>,
  val production_countries: List<ProductionCountry>,
  val release_date: String?,
  val revenue: Int,
  val spoken_languages: List<SpokenLanguage>,
  val status: String,
  val tagline: String,
  val vote_average: Double,
  val vote_count: Int
)