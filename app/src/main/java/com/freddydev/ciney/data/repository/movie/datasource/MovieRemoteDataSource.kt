package com.freddydev.ciney.data.repository.movie.datasource

import com.freddydev.ciney.domain.model.movie.MoviesResult
import retrofit2.Response

interface MovieRemoteDataSource {

  suspend fun getNowPlayingMovies(page: Int?): Response<MoviesResult>
}
