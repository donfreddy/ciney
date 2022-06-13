package com.freddydev.ciney.domain.usecase.movie.get_movies

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMoviesUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<List<Movie>>> {
    return movieRepos.getMovies(category = params.category, page = params.page)
  }

  data class Params(val category: String, val page: Int)
}