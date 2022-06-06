package com.freddydev.ciney.domain.model.movie

import androidx.compose.runtime.Immutable
import androidx.room.Entity

@Immutable
@Entity(tableName = "movies", primaryKeys = ["id"])
data class Movie(
  val id: Int,
  val title: String,
  val original_title: String,
  val backdrop_path: String,
  val poster_path: String,
  val popularity: Double,
  val vote_average: Double,
  val vote_count: Int,
  val release_date: String
)