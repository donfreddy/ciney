package com.freddydev.ciney.domain.model.person

import com.freddydev.ciney.domain.model.person.KnownFor

data class Person(
  val id: Int,
  val name: String,
  val adult: Boolean,
  val gender: Int,
  val known_for: List<KnownFor>,
  val known_for_department: String,
  val popularity: Double,
  val profile_path: String
)
