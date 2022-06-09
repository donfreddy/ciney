package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.domain.model.trending.Trending
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {

  fun getTrending(
    mediaType: String,
    timeWindow: String,
    page: Int
  ): Flow<Resource<List<Trending>>>
}