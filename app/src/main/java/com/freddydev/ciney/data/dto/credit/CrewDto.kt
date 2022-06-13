package com.freddydev.ciney.data.dto.credit

import com.freddydev.ciney.domain.model.credit.Crew

data class CrewDto(
  val adult: Boolean,
  val credit_id: String,
  val department: String,
  val gender: Int,
  val id: Int,
  val job: String,
  val known_for_department: String,
  val name: String,
  val original_name: String,
  val popularity: Double,
  val profile_path: String
)

fun CrewDto.toCrew() = Crew(
  id = id,
  name = name,
  department = department,
  job = job,
  credit_id = credit_id,
  gender = gender,
  known_for_department = known_for_department,
  original_name = original_name,
  popularity = popularity,
  profile_path = profile_path
)