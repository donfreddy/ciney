package com.freddydev.ciney.data.repository.trenting.datasource

import com.freddydev.ciney.data.dto.trending.TrendingResultDto
import retrofit2.Response

interface TrendingRemoteDatasource {

  suspend fun getTrending(
    mediaType: String,
    timeWindow: String,
    page: Int
  ): Response<TrendingResultDto>
}