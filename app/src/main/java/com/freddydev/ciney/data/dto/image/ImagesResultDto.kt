package com.freddydev.ciney.data.dto.image

import com.freddydev.ciney.domain.model.image.BackdropDto

data class ImagesResultDto(
  val id: Int,
  val backdrops: List<BackdropDto>,
  val posters: List<PosterDto>
)