package com.freddydev.ciney.data.repository.movie

import com.freddydev.ciney.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * This class is a implementation of [MovieRepository]
 */
class MovieRepositoryImpl @Inject constructor(
  private val movieRemoteDataSource: MovieRemoteDataSourceImpl
) : MovieRepository {

  override suspend fun getNowPlayingMovies(page: Int?): List<Movie> {
    lateinit var movies: List<Movie>
    Timber.i("### GET tNowPlayingMovies")
    try {
      val response = movieRemoteDataSource.getNowPlayingMovies(page)
      val body = response.body()
      Timber.i("#### Body getNowPlayingMovies")
      Timber.i(body.toString())
      if (body != null) {
        movies = body.movies
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return movies
  }
}