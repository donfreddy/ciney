package com.freddydev.ciney.data.dto.review

data class ReviewsResultDto(
  val id: Int,
  val page: Int,
  val reviews: List<ReviewDto>,
  val total_pages: Int,
  val total_results: Int
)