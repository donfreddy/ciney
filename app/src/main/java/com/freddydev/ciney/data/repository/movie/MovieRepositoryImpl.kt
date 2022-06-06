package com.freddydev.ciney.data.repository.movie

import androidx.annotation.WorkerThread
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

/**
 * This class is a implementation of [MovieRepository]
 */
class MovieRepositoryImpl constructor(
  private val movieRemoteDatasource: MovieRemoteDatasource,
  private val movieLocalDataSource: MovieLocalDatasource,
) : MovieRepository {

  @WorkerThread
  override fun getLatestMovie(

  ): MovieDetailDto {

  }

  @WorkerThread
  override suspend fun getMovies(category: String, page: Int): List<Movie> {
    var movies: List<Movie> = emptyList()

//    try {
//      val response = movieRemoteDatasource.getMovies(category, page)
//      val body = response.body()
//      if (body != null) {
//        movies = body.movies
//      }
//    } catch (exception: Exception) {
//      exception.printStackTrace()
//    }
    return movies
  }
}