package com.freddydev.ciney.data.dto.review

import com.freddydev.ciney.domain.model.review.ReviewsResult

data class ReviewsResultDto(
  val id: Int,
  val page: Int,
  val reviews: List<ReviewDto>,
  val total_pages: Int,
  val total_results: Int
)

fun ReviewsResultDto.toReviewsResult() = ReviewsResult(
  reviews = reviews.map { it.toReview() },
)