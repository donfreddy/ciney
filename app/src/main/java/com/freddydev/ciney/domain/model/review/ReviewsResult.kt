package com.freddydev.ciney.domain.model.review

data class ReviewsResult(
  val id: Int,
  val page: Int,
  val reviews: List<Review>,
  val total_pages: Int,
  val total_results: Int
)