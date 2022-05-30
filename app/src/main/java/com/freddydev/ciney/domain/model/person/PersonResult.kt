package com.freddydev.ciney.domain.model.person

import com.freddydev.ciney.domain.model.person.Person

data class PersonResult(
  val page: Int,
  val artists: List<Person>,
  val total_pages: Int,
  val total_results: Int
)
