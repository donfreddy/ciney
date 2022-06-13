package com.freddydev.ciney.data.repository.movie.data_source

import com.freddydev.ciney.data.dto.credit.CreditsResultDto
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesResultDto
import com.freddydev.ciney.data.dto.review.ReviewsResultDto
import com.freddydev.ciney.data.dto.image.ImagesResultDto
import com.freddydev.ciney.data.dto.video.VideosResultDto
import retrofit2.Response

interface MovieRemoteDatasource {

  suspend fun getMovies(category: String, page: Int): Response<MoviesResultDto>

  suspend fun getMovieDetail(movieId: Int): Response<MovieDetailDto>

  suspend fun getSimilarMovies(movieId: Int, page: Int): Response<MoviesResultDto>

  suspend fun getRecommendedMovies(movieId: Int, page: Int): Response<MoviesResultDto>

  suspend fun getMovieVideos(movieId: Int): Response<VideosResultDto>

  suspend fun getMovieReviews(movieId: Int): Response<ReviewsResultDto>

  suspend fun getMovieImages(movieId: Int): Response<ImagesResultDto>

  suspend fun getMovieCredits(movieId: Int): Response<CreditsResultDto>
}
