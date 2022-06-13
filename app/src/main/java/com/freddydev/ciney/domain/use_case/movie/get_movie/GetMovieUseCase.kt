package com.freddydev.ciney.domain.use_case.movie.get_movie

import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.use_case.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
  private val movieRepos: MovieRepository
) : UseCase<MovieDetail, GetMovieUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<MovieDetail>> {
    return movieRepos.getMovieDetail(movieId = params.movieId)
  }

  class Params(val movieId: Int)
}
