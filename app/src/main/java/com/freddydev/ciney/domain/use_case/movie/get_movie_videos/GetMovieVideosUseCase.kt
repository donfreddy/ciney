package com.freddydev.ciney.domain.use_case.movie.get_movie_videos

import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.video.Video
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.use_case.UseCase
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieVideosUseCase @Inject constructor(
  private val movieRepos: MovieRepository,
) : UseCase<List<Movie>, GetMovieVideosUseCase.Params>() {

  fun execute(params: Params): Flow<Resource<List<Video>>> {
    return movieRepos.getMovieVideos(movieId = params.movieId)
  }

  data class Params(val movieId: Int)
}