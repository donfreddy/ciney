package com.freddydev.ciney.data.repository.trenting.data_source_impl

import com.freddydev.ciney.data.api.services.TrendingService
import com.freddydev.ciney.data.dto.trending.TrendingResultDto
import com.freddydev.ciney.data.repository.trenting.data_source.TrendingRemoteDatasource
import retrofit2.Response
import javax.inject.Inject

class TrendingRemoteDatasourceImpl @Inject constructor(private val trendingService: TrendingService) :
  TrendingRemoteDatasource {

  override suspend fun getTrending(
    mediaType: String,
    timeWindow: String,
    page: Int
  ): Response<TrendingResultDto> {
    return trendingService.getTrending(
      mediaType = mediaType,
      timeWindow = timeWindow,
      page = page
    )
  }

}