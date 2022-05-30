package com.freddydev.ciney.domain.usecase.movie

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
  private val page: Int?
) {

  suspend fun execute(): List<Movie> = movieRepos.getNowPlayingMovies(page = page)
}