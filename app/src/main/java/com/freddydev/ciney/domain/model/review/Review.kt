package com.freddydev.ciney.domain.model.review

data class Review(
  val id: String,
  val author: String,
  val author_details: AuthorDetail,
  val content: String,
  val created_at: String,
  val updated_at: String,
  val url: String
)