package com.freddydev.ciney.data.dto.credit

import com.freddydev.ciney.domain.model.credit.CreditsResult

data class CreditsResultDto(
  val id: Int,
  val cast: List<CastDto>,
  val crew: List<CrewDto>
)

fun CreditsResultDto.toCreditsResult(): CreditsResult {
  return CreditsResult(
    cast = cast.map { it.toCast() },
    crew = crew.map { it.toCrew() }
  )
}