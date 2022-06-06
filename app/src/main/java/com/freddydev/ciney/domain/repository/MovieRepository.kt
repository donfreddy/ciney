package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

  fun getLatestMovie(): MovieDetailDto

  suspend fun getMovies(category: String, page: Int): List<MoviesDto>
}