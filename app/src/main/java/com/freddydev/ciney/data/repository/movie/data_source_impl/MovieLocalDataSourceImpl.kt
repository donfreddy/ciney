package com.freddydev.ciney.data.repository.movie.data_source_impl

import com.freddydev.ciney.data.database.dao.MovieDao
import com.freddydev.ciney.data.repository.movie.data_source.MovieLocalDatasource
import com.freddydev.ciney.domain.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) :
  MovieLocalDatasource {
  override suspend fun getMoviesFromDB(): List<Movie> {
    return movieDao.getMovies()
  }

  override suspend fun saveMoviesToDB(movies: List<Movie>) {
    CoroutineScope(Dispatchers.IO).launch {
      movieDao.saveMovies(movies)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope(Dispatchers.IO).launch {
      movieDao.deleteAllMovies()
    }
  }
}