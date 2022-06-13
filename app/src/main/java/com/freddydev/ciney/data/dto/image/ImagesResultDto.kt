package com.freddydev.ciney.data.dto.image

import com.freddydev.ciney.domain.model.image.ImagesResult

data class ImagesResultDto(
  val id: Int,
  val backdrops: List<BackdropDto>,
  val posters: List<PosterDto>
)

fun ImagesResultDto.toImagesResult() = ImagesResult(
  backdrops.map { it.toBackdrop() },
  posters.map { it.toPoster() }
)