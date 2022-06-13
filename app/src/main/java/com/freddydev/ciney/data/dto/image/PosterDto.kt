package com.freddydev.ciney.data.dto.image

import com.freddydev.ciney.domain.model.image.Poster

data class PosterDto(
  val aspect_ratio: Double,
  val file_path: String,
  val height: Int,
  val iso_639_1: String,
  val vote_average: Int,
  val vote_count: Int,
  val width: Int
)

fun PosterDto.toPoster() = Poster(
  aspect_ratio = aspect_ratio,
  file_path = file_path,
  height = height,
  vote_average = vote_average,
  vote_count = vote_count,
  width = width
)