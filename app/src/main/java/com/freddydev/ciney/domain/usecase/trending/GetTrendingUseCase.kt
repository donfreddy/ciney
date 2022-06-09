package com.freddydev.ciney.domain.usecase.trending

import com.freddydev.ciney.domain.model.trending.Trending
import com.freddydev.ciney.domain.repository.TrendingRepository
import com.freddydev.ciney.domain.usecase.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingUseCase @Inject constructor(
  private val trendingRepos: TrendingRepository
) : UseCase<List<Trending>, GetTrendingUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<List<Trending>>> {
    return trendingRepos.getTrending(
      mediaType = params.mediaType,
      timeWindow = params.timeWindow,
      page = params.page
    )
  }

  data class Params(
    val mediaType: String,
    val timeWindow: String,
    val page: Int
  )
}