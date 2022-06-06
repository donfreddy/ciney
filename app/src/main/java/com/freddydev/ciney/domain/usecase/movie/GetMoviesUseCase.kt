package com.freddydev.ciney.domain.usecase.movie

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.UseCase
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMoviesUseCase.Params>() {

  override suspend fun execute(params: Params): List<Movie> {
    return movieRepos.getMovies(category = params.category, page = params.page)
  }

  data class Params(val category: String, val page: Int)
}