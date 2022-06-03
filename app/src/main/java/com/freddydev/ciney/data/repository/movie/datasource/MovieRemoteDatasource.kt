package com.freddydev.ciney.data.repository.movie.datasource

import com.freddydev.ciney.domain.model.movie.MoviesResult
import retrofit2.Response

interface MovieRemoteDatasource {

  suspend fun getNowPlayingMovies(page: Int?): Response<MoviesResult>
}
