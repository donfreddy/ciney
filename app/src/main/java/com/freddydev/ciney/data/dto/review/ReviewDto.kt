package com.freddydev.ciney.data.dto.review

import com.freddydev.ciney.domain.model.review.Review

data class ReviewDto(
  val author: String,
  val author_details: AuthorDetailDto,
  val content: String,
  val created_at: String,
  val id: String,
  val updated_at: String,
  val url: String
)

fun ReviewDto.toReview() = Review(
  author = author,
  author_details = author_details.toAuthorDetail(),
  content = content,
  created_at = created_at,
  id = id,
  updated_at = updated_at,
  url = url
)