package com.freddydev.ciney.data.dto.review

import com.freddydev.ciney.domain.model.review.AuthorDetail

data class AuthorDetailDto(
  val avatar_path: String,
  val name: String,
  val rating: Any,
  val username: String
)

fun AuthorDetailDto.toAuthorDetail() = AuthorDetail(
  avatar_path = avatar_path,
  name = name,
  rating = rating,
  username = username
)