package com.freddydev.ciney.data.dto.video

import com.freddydev.ciney.domain.model.video.Video

data class VideoDto(
  val id: String,
  val iso_3166_1: String,
  val iso_639_1: String,
  val key: String,
  val name: String,
  val official: Boolean,
  val published_at: String,
  val site: String,
  val size: Int,
  val type: String
)

fun VideoDto.toVideo() = Video(
  id = id,
  key = key,
  name = name,
  official = official,
  published_at = published_at,
  site = site,
  size = size,
  type = type
)