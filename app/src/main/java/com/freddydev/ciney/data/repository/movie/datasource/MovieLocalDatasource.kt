package com.freddydev.ciney.data.repository.movie.datasource

import com.freddydev.ciney.domain.model.movie.Movie

interface MovieLocalDatasource {
  suspend fun getMoviesFromDB(): List<Movie>
  suspend fun saveMoviesToDB(movies: List<Movie>)
  suspend fun clearAll()
}