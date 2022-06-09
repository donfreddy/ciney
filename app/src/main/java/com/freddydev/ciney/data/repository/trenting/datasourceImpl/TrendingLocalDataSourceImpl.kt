package com.freddydev.ciney.data.repository.trenting.datasourceImpl

import com.freddydev.ciney.data.database.dao.TrendingDao
import com.freddydev.ciney.data.repository.trenting.datasource.TrendingLocalDatasource
import com.freddydev.ciney.domain.model.trending.Trending

class TrendingLocalDataSourceImpl(private val trendingDao: TrendingDao) : TrendingLocalDatasource {

  override suspend fun getTrendingFromDB(): List<Trending> {
    return trendingDao.getTrending()
  }

  override suspend fun saveTrendingToDB(trending: List<Trending>) {
    return trendingDao.saveTrending(trending = trending)
  }

  override suspend fun clearAll() {
    return trendingDao.deleteTrending()
  }
}