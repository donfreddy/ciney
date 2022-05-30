package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail

interface MovieRepository {

  suspend fun getNowPlayingMovies(page: Int?): List<Movie>
}