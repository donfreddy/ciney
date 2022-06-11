package com.freddydev.ciney.domain.usecase.movie

import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
  private val movieRepository: MovieRepository
) : UseCase<MovieDetail, GetMovieDetailUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<MovieDetail>> {
    return movieRepository.getMovieDetail(movieId = params.movieId)
  }

  class Params(val movieId: Int)
}
