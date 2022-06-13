package com.freddydev.ciney.data.repository.movie.datasourceImpl

import com.freddydev.ciney.data.api.services.MovieService
import com.freddydev.ciney.data.dto.credit.CreditsResultDto
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesResultDto
import com.freddydev.ciney.data.dto.review.ReviewsResultDto
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.data.dto.image.ImagesResultDto
import com.freddydev.ciney.domain.model.video.VideosResultDto
import retrofit2.Response
import javax.inject.Inject

/**
 * This class is an implementation of [MovieRemoteDatasource]
 */
class MovieRemoteDatasourceImpl @Inject constructor(private val movieService: MovieService) :
  MovieRemoteDatasource {

  override suspend fun getMovies(category: String, page: Int): Response<MoviesResultDto> {
    return movieService.get(category, page)
  }

  override suspend fun getMovieDetail(movieId: Int): Response<MovieDetailDto> {
    return movieService.getDetail(id = movieId)
  }

  override suspend fun getSimilarMovies(movieId: Int, page: Int): Response<MoviesResultDto> {
    return movieService.getSimilar(id = movieId, page = page)
  }

  override suspend fun getRecommendedMovies(movieId: Int, page: Int): Response<MoviesResultDto> {
    return movieService.getRecommended(id = movieId, page = page)
  }

  override suspend fun getMovieVideos(movieId: Int): Response<VideosResultDto> {
    return movieService.getVideos(id = movieId)
  }

  override suspend fun getMovieReviews(movieId: Int): Response<ReviewsResultDto> {
    return movieService.getReviews(id = movieId)
  }

  override suspend fun getMovieImages(movieId: Int): Response<ImagesResultDto> {
    return movieService.getImages(id = movieId)
  }

  override suspend fun getMovieCredits(movieId: Int): Response<CreditsResultDto> {
    return movieService.getCredits(id = movieId)
  }
}