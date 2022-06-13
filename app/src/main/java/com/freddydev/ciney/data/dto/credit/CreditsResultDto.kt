package com.freddydev.ciney.data.dto.credit

import com.freddydev.ciney.domain.model.credit.CastDto
import com.freddydev.ciney.domain.model.credit.CreditsResult
import com.freddydev.ciney.domain.model.credit.CrewDto

data class CreditsResultDto(
  val id: Int,
  val cast: List<CastDto>,
  val crew: List<CrewDto>
)

fun CreditsResultDto.toCreditsResult(): CreditsResult {
  return CreditsResult(
    cast = cast.map { it },
    crew = crew.map { it }
  )
}