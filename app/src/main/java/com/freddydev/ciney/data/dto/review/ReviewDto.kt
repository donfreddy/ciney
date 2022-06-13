package com.freddydev.ciney.data.dto.review

data class ReviewDto(
  val author: String,
  val author_details: AuthorDetailDto,
  val content: String,
  val created_at: String,
  val id: String,
  val updated_at: String,
  val url: String
)