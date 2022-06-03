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

  /** Get the most newly created movie. */
  @GET("/movie/latest")
  fun latestMovie(): Response<MovieDetail?>

  /** Get a list of movies in theatres. */
  @GET("/movie/now_playing")
  fun nowPlaying(@Query("page") page: Int? = 1): Response<MoviesResult>

  /** Get a list of the current popular movies on TMDB. This list updates daily.*/
  @GET("/movie/popular")
  fun popular(@Query("page") page: Int): Response<MoviesResult>

  /** Get the top rated movies on TMDB. */
  @GET("/movie/top_rated")
  fun topRated(@Query("page") page: Int): Response<MoviesResult>

  /** Get a list of upcoming movies in theatres. */
  @GET("/movie/upcoming")
  fun upcoming(@Query("page") page: Int): Response<MoviesResult>

  /** Get the primary information about a movie. */
  @GET("/movie/{movie_id}")
  fun movieById(@Path("movie_id") id: String): Response<MovieDetail>

  /** Get a list of similar movies. */
  @GET("/movie/{movie_id}/similar")
  fun similar(
    @Path("movie_id") id: String, @Query("page") page: Int
  ): Response<MoviesResult>

  /** Get a list of recommended movies for a movie. */
  @GET("/movie/{movie_id}/recommendations")
  fun recommendations(
    @Path("movie_id") id: String, @Query("page") page: Int
  ): Response<MoviesResult>

  /** Get the videos that have been added to a movie. */
  @GET("/movie/{movie_id}/videos")
  fun movieVideos(@Path("movie_id") id: String): Response<VideosResult>

  /** Get the user reviews for a movie. */
  @GET("/movie/{movie_id}/reviews")
  fun movieReviews(@Path("movie_id") id: String): Response<ReviewsResult>

  /** Get the images that belong to a movie. */
  @GET("/movie/{movie_id}/images")
  fun movieImages(@Path("movie_id") id: String): Response<ImagesResult>

  /** Get the cast and crew for a movie. */
  @GET("/movie/{movie_id}/credits")
  fun movieCredits(@Path("movie_id") id: String): Response<MoviesResult>

  /** Rate a movie. */
  @POST("/movie/{movie_id/rating}")
  fun rateMovie(@Path("movie_id") id: String): Response<MoviesResult>

  /** Remove your rating for a movie. */
  @DELETE("/movie/{movie_id/rating}")
  fun deleteRating(@Path("movie_id") id: String): Response<MoviesResult>
}