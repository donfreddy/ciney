package com.freddydev.ciney.data.dto.trending

import com.freddydev.ciney.domain.model.trending.TrendingResult

data class TrendingResultDto(
  val page: Int,
  val results: List<TrendingDto>,
  val total_pages: Int,
  val total_results: Int
)

fun TrendingResultDto.toTrendingResult(): TrendingResult {
  return TrendingResult(
    results = results.map { it.toTrending() }
  )
}