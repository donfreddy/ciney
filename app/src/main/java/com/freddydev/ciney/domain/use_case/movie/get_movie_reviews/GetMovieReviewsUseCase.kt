package com.freddydev.ciney.domain.use_case.movie.get_movie_reviews

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.review.Review
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.use_case.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMovieReviewsUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<List<Review>>> {
    return movieRepos.getMovieReviews(movieId = params.movieId)
  }

  data class Params(val movieId: Int)
}