package com.freddydev.ciney.data.repository.movie.datasource

import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto

interface MovieRemoteDatasource {

  suspend fun getLatestMovie(): MovieDetailDto

  suspend fun getMovies(category: String, page: Int): List<MoviesDto>
}
