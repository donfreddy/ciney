package com.freddydev.ciney.data.repository.trenting

import androidx.annotation.WorkerThread
import com.freddydev.ciney.data.dto.trending.toTrendingResult
import com.freddydev.ciney.data.repository.trenting.datasource.TrendingLocalDatasource
import com.freddydev.ciney.data.repository.trenting.datasource.TrendingRemoteDatasource
import com.freddydev.ciney.domain.model.trending.Trending
import com.freddydev.ciney.domain.repository.TrendingRepository
import com.freddydev.ciney.util.Constants
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TrendingRepositoryImpl constructor(
  private val trendingRemoteDatasource: TrendingRemoteDatasource,
  private val trendingLocalDatasource: TrendingLocalDatasource
) : TrendingRepository {

  @WorkerThread
  override fun getTrending(
    mediaType: String,
    timeWindow: String,
    page: Int
  ): Flow<Resource<List<Trending>>> = flow {
    try {
      emit(Resource.Loading())
      val responseBody = trendingRemoteDatasource.getTrending(mediaType, timeWindow, page).body()
      if (responseBody != null) {
        val trendingList: List<Trending> = responseBody.toTrendingResult().results

        // Todo: Save trendingList in local database

        emit(Resource.Success(trendingList))
      }
    } catch (e: HttpException) {
      emit(Resource.Error(message = Constants.HTTP_EXCEPT_MSG))
    } catch (e: IOException) {

      /**
       * Todo: Get data from [trendingLocalDatasource] if no connexion.
       */
      emit(Resource.Error(message = Constants.IO_EXCEPT_MSG))
    }
  }
}