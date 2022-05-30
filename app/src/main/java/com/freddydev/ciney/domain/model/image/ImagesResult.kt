package com.freddydev.ciney.domain.model.image

data class ImagesResult(
  val id: Int,
  val backdrops: List<Backdrop>,
  val posters: List<Poster>
)