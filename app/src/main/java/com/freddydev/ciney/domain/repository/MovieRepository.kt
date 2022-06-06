package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.domain.model.movie.Movie

interface MovieRepository {

  suspend fun getMovies(category: String, page: Int): List<Movie>
}