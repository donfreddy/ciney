package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

  fun getLatestMovie(): Flow<Resource<MovieDetail>>

  fun getMovies(category: String, page: Int): Flow<Resource<List<Movie>>>
}