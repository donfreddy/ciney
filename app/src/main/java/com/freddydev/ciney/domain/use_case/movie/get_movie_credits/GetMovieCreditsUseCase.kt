package com.freddydev.ciney.domain.use_case.movie.get_movie_credits

import com.freddydev.ciney.domain.model.credit.CreditsResult
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.use_case.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMovieCreditsUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<CreditsResult>> {
    return movieRepos.getMovieCredits(movieId = params.movieId)
  }

  data class Params(val movieId: Int)
}