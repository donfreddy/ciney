package com.freddydev.ciney.domain.use_case.movie.get_movie_images

import com.freddydev.ciney.domain.model.image.ImagesResult
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.use_case.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMovieImagesUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<ImagesResult>> {
    return movieRepos.getMovieImages(movieId = params.movieId)
  }

  data class Params(val movieId: Int)
}