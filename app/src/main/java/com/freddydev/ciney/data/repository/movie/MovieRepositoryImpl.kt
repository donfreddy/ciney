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

  @WorkerThread
  override suspend fun getNowPlayingMovies(page: Int?): List<Movie> {
    lateinit var movies: List<Movie>
    Timber.i("### GET tNowPlayingMovies")
    try {
      val response = movieRemoteDatasource.getNowPlayingMovies(page = page)
      val body = response.body()
      Timber.i("#### Body getNowPlayingMovies")
      Timber.i(body.toString())
      if (body != null) {
        movies = body.movies
      }
    } catch (exception: Exception) {
      Timber.i(exception.message.toString())
      exception.printStackTrace()
    }
    return movies
  }
}