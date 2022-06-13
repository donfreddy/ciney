package com.freddydev.ciney.data.dto.image

import com.freddydev.ciney.domain.model.image.Backdrop

data class BackdropDto(
  val aspect_ratio: Double,
  val file_path: String,
  val height: Int,
  val iso_639_1: Any,
  val vote_average: Int,
  val vote_count: Int,
  val width: Int
)

fun BackdropDto.toBackdrop() = Backdrop(
  aspect_ratio = aspect_ratio,
  file_path = file_path,
  height = height,
  vote_average = vote_average,
  vote_count = vote_count,
  width = width
)