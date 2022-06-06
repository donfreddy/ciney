package com.freddydev.ciney.data.api.services

import com.freddydev.ciney.domain.model.image.ImagesResult
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.movie.MoviesResult
import com.freddydev.ciney.domain.model.review.ReviewsResult
import com.freddydev.ciney.domain.model.video.VideosResult
import retrofit2.Response
import retrofit2.http.*

/**
 * [Movies endpoints](https://developers.themoviedb.org/3/movies)
 */
interface MovieService {

  /**
   * Get movies list by now playing, upcoming, popular or top rated.
   * @param [category] The category of movies to get. Possible values: now_playing, upcoming, popular, top_rated.
   * @param [page] The page of results to return. Default: 1.
   * @return [Response] with [MoviesResult]
   */
  @GET("/movie/{category}")
  suspend fun getMovies(
    @Path("category") category: String,
    @Query("page") page: Int
  ): Response<MoviesResult>

  /** Get the primary information about a movie. */
  @GET("/movie/{movie_id}")
  suspend fun movieById(@Path("movie_id") id: String): Response<MovieDetail>

  /** Get a list of similar movies. */
  @GET("/movie/{movie_id}/similar")
  suspend fun similar(
    @Path("movie_id") id: String, @Query("page") page: Int
  ): Response<MoviesResult>

  /** Get a list of recommended movies for a movie. */
  @GET("/movie/{movie_id}/recommendations")
  suspend fun recommendations(
    @Path("movie_id") id: String, @Query("page") page: Int
  ): Response<MoviesResult>

  /** Get the videos that have been added to a movie. */
  @GET("/movie/{movie_id}/videos")
  suspend fun movieVideos(@Path("movie_id") id: String): Response<VideosResult>

  /** Get the user reviews for a movie. */
  @GET("/movie/{movie_id}/reviews")
  suspend fun movieReviews(@Path("movie_id") id: String): Response<ReviewsResult>

  /** Get the images that belong to a movie. */
  @GET("/movie/{movie_id}/images")
  suspend fun movieImages(@Path("movie_id") id: String): Response<ImagesResult>

  /** Get the cast and crew for a movie. */
  @GET("/movie/{movie_id}/credits")
  suspend fun movieCredits(@Path("movie_id") id: String): Response<MoviesResult>

  /** Rate a movie. */
  @POST("/movie/{movie_id/rating}")
  suspend fun rateMovie(@Path("movie_id") id: String): Response<MoviesResult>

  /** Remove your rating for a movie. */
  @DELETE("/movie/{movie_id/rating}")
  suspend fun deleteRating(@Path("movie_id") id: String): Response<MoviesResult>
}