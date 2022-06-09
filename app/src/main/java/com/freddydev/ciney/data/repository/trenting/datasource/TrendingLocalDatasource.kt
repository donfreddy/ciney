package com.freddydev.ciney.data.repository.trenting.datasource

import com.freddydev.ciney.domain.model.trending.Trending

interface TrendingLocalDatasource {

  suspend fun getTrendingFromDB(): List<Trending>

  suspend fun saveTrendingToDB(trending: List<Trending>)

  suspend fun clearAll()
}