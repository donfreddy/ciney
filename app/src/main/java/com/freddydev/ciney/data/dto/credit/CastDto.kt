package com.freddydev.ciney.data.dto.credit

import com.freddydev.ciney.domain.model.credit.Cast

data class CastDto(
  val adult: Boolean,
  val cast_id: Int,
  val character: String,
  val credit_id: String,
  val gender: Int,
  val id: Int,
  val known_for_department: String,
  val name: String,
  val order: Int,
  val original_name: String,
  val popularity: Double,
  val profile_path: String
)

fun CastDto.toCast() = Cast(
  id = id,
  name = name,
  cast_id = cast_id,
  character = character,
  credit_id = credit_id,
  gender = gender,
  known_for_department = known_for_department,
  order = order,
  original_name = original_name,
  popularity = popularity,
  profile_path = profile_path
)