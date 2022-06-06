package com.freddydev.ciney.data.repository.movie.datasourceImpl

import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.data.api.services.MovieService
import com.freddydev.ciney.domain.model.movie.MoviesResult
import retrofit2.Response
import javax.inject.Inject

/**
 * This class is an implementation of [MovieRemoteDatasource]
 */
class MovieRemoteDatasourceImpl @Inject constructor(private val movieService: MovieService) :
  MovieRemoteDatasource {

  override suspend fun getMovies(category: String, page: Int): Response<MoviesResult> {
    return movieService.getMovies(category, page)
  }
}