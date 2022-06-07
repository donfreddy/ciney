package com.freddydev.ciney.data.repository.movie.datasource

import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto
import retrofit2.Response

interface MovieRemoteDatasource {

  suspend fun getLatestMovie(): Response<MovieDetailDto>

  suspend fun getMovies(category: String, page: Int): Response<MoviesDto>
}
