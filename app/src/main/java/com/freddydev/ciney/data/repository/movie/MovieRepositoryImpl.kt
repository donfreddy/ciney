package com.freddydev.ciney.data.repository.movie

import androidx.annotation.WorkerThread
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * This class is a implementation of [MovieRepository]
 */
class MovieRepositoryImpl constructor(
  private val movieRemoteDatasource: MovieRemoteDatasource,
  private val movieLocalDataSource: MovieLocalDatasource,
) : MovieRepository {

  // @WorkerThread
  override suspend fun getMovies(category: String, page: Int): List<Movie> {
    var movies: List<Movie> = emptyList()
    println("### GET NowPlayingMovies")
    try {
      println("#### Start Body getNowPlayingMovies")
      val response = movieRemoteDatasource.getMovies(category, page)
      val body = response.body()
      println(body.toString())
      println("#### End Body getNowPlayingMovies")
      if (body != null) {
        movies = body.movies
      }
    } catch (exception: Exception) {
      exception.printStackTrace()
    }
    return movies
  }
}