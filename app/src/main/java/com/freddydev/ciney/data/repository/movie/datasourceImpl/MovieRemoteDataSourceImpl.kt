package com.freddydev.ciney.data.repository.movie.datasourceImpl

import com.freddydev.ciney.data.api.ApiService
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDataSource
import com.freddydev.ciney.domain.model.movie.MoviesResult
import retrofit2.Response
import javax.inject.Inject

/**
 * This class is an implementation of [MovieRemoteDataSource]
 */
class MovieRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
  MovieRemoteDataSource {

  override suspend fun getNowPlayingMovies(page: Int?): Response<MoviesResult> {
    return apiService.nowPlayingMovies(page = page)
  }
}