package com.freddydev.ciney.data.api.services

import com.freddydev.ciney.data.dto.credit.CreditsResultDto
import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesResultDto
import com.freddydev.ciney.data.dto.image.ImagesResultDto
import com.freddydev.ciney.data.dto.review.ReviewsResultDto
import com.freddydev.ciney.domain.model.orther.RateResponse
import com.freddydev.ciney.data.dto.video.VideosResultDto
import retrofit2.Response
import retrofit2.http.*

/**
 * [Movies endpoints](https://developers.themoviedb.org/3/movies)
 */
interface MovieService {

  /**
   * Get movies list by now playing, upcoming, popular or top rated.
   */
  @GET("/3/movie/{category}")
  suspend fun get(
    @Path(CATEGORY) category: String,
    @Query(PAGE) page: Int
  ): Response<MoviesResultDto>

  /** Get movie details by id. */
  @GET("/3/movie/{movie_id}")
  suspend fun getDetail(@Path(MOVIE_ID) id: Int): Response<MovieDetailDto>

  /** Get a list of similar movies. */
  @GET("/3/movie/{movie_id}/similar")
  suspend fun getSimilar(
    @Path(MOVIE_ID) id: Int, @Query(PAGE) page: Int
  ): Response<MoviesResultDto>

  /** Get a list of recommended movies for a movie. */
  @GET("/3/movie/{movie_id}/recommendations")
  suspend fun getRecommended(
    @Path(MOVIE_ID) id: Int, @Query(PAGE) page: Int
  ): Response<MoviesResultDto>

  /** Get the videos that have been added to a movie. */
  @GET("/3/movie/{movie_id}/videos")
  suspend fun getVideos(@Path(MOVIE_ID) id: Int): Response<VideosResultDto?>

  /** Get the user reviews for a movie. */
  @GET("/3/movie/{movie_id}/reviews")
  suspend fun getReviews(@Path(MOVIE_ID) id: Int): Response<ReviewsResultDto>

  /** Get the images that belong to a movie. */
  @GET("/3/movie/{movie_id}/images")
  suspend fun getImages(@Path(MOVIE_ID) id: Int): Response<ImagesResultDto>

  /** Get the cast and crew for a movie. */
  @GET("/3/movie/{movie_id}/credits")
  suspend fun getCredits(@Path(MOVIE_ID) id: Int): Response<CreditsResultDto>

  /** Rate a movie. */
  @POST("/3/movie/{movie_id/rating}")
  suspend fun rateMovie(@Path(MOVIE_ID) id: Int): Response<RateResponse>

  /** Remove your rating for a movie. */
  @DELETE("/3/movie/{movie_id/rating}")
  suspend fun deleteRating(@Path(MOVIE_ID) id: Int): Response<RateResponse>

  companion object {
    const val PAGE = "page"
    const val CATEGORY = "category"
    private const val MOVIE_ID = "movie_id"
  }
}