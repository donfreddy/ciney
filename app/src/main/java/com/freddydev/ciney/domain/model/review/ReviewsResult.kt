package com.freddydev.ciney.domain.model.review

import com.freddydev.ciney.data.dto.review.ReviewDto

data class ReviewsResult(
  val id: Int,
  val page: Int,
  val reviews: List<ReviewDto>,
  val total_pages: Int,
  val total_results: Int
)