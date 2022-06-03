package com.freddydev.ciney.domain.model.movie

import androidx.compose.runtime.Immutable
import androidx.room.Entity

@Immutable
@Entity(tableName = "movies", primaryKeys = ["id"])
data class Movie(
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