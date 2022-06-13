package com.freddydev.ciney.domain.model.image

import com.freddydev.ciney.data.dto.image.PosterDto

data class ImagesResult(
  val id: Int,
  val backdrops: List<BackdropDto>,
  val posters: List<PosterDto>
)