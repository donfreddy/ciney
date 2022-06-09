package com.freddydev.ciney.domain.model.trending

import androidx.compose.runtime.Immutable
import androidx.room.Entity

@Immutable
@Entity(tableName = "trending", primaryKeys = ["id"])
data class Trending(
  val id: Int,
  val name: String?,
  val title: String?,
  val media_type: String,
  val backdrop_path: String?,
  val first_air_date: String?,
  val original_language: String,
  val original_name: String?,
  val original_title: String?,
  val overview: String,
  val popularity: Double,
  val poster_path: String?,
  val release_date: String?,
  val vote_count: Int
)