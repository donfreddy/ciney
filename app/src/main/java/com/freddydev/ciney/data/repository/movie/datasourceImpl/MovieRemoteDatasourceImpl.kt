package com.freddydev.ciney.data.repository.movie.datasourceImpl

import com.freddydev.ciney.data.api.services.MovieService
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import javax.inject.Inject

/**
 * This class is an implementation of [MovieRemoteDatasource]
 */
class MovieRemoteDatasourceImpl @Inject constructor(private val movieService: MovieService) :
  MovieRemoteDatasource {

  override suspend fun getLatestMovie(): MovieDetailDto {
    return movieService.latestMovie()
  }

  override suspend fun getMovies(category: String, page: Int): List<MoviesDto> {
    return movieService.getMovies(category, page)
  }
}