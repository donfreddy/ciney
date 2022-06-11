package com.freddydev.ciney.data.repository.movie.datasourceImpl

import com.freddydev.ciney.data.api.services.MovieService
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.util.Resource
import retrofit2.Response
import javax.inject.Inject

/**
 * This class is an implementation of [MovieRemoteDatasource]
 */
class MovieRemoteDatasourceImpl @Inject constructor(private val movieService: MovieService) :
  MovieRemoteDatasource {

  override suspend fun getMovies(category: String, page: Int): Response<MoviesDto> {
    return movieService.getMovies(category, page)
  }

  override suspend fun getMovieDetail(movieId: Int): Response<MovieDetailDto> {
    return movieService.getMovieDetail(id = movieId)
  }
}