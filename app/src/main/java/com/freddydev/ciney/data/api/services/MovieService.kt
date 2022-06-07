package com.freddydev.ciney.data.api.services

import com.freddydev.ciney.data.dto.movie.MovieDetailDto
import com.freddydev.ciney.data.dto.movie.MoviesDto
import com.freddydev.ciney.domain.model.image.ImagesResult
import com.freddydev.ciney.domain.model.review.ReviewsResult
import com.freddydev.ciney.domain.model.video.VideosResult
import retrofit2.Response
import retrofit2.http.*

/**
 * [Movies endpoints](https://developers.themoviedb.org/3/movies)
 */
interface MovieService {

  /** Get the most newly created movie. */
  @GET("/3/movie/latest")
  suspend fun latestMovie(): Response<MovieDetailDto>

  /**
   * Get movies list by now playing, upcoming, popular or top rated.
   * @param [category] The category of movies to get. Possible values: now_playing, upcoming, popular, top_rated.
   * @param [page] The page of results to return. Default: 1.
   * @return [Response] with [MoviesDto]
   */
  @GET("/3/movie/{category}")
  suspend fun getMovies(
    @Path(CATEGORY) category: String,
    @Query(PAGE) page: Int
  ): Response<MoviesDto>

  /** Get the primary information about a movie. */
  @GET("/3/movie/{movie_id}")
  suspend fun movieById(@Path(MOVIE_ID) id: String): Response<MovieDetailDto>

  /** Get a list of similar movies. */
  @GET("/3/movie/{movie_id}/similar")
  suspend fun similar(
    @Path(MOVIE_ID) id: String, @Query(PAGE) page: Int
  ): Response<MoviesDto>

  /** Get a list of recommended movies for a movie. */
  @GET("/3/movie/{movie_id}/recommendations")
  suspend fun recommendations(
    @Path(MOVIE_ID) id: String, @Query(PAGE) page: Int
  ): Response<MoviesDto>

  /** Get the videos that have been added to a movie. */
  @GET("/3/movie/{movie_id}/videos")
  suspend fun movieVideos(@Path(MOVIE_ID) id: String): Response<VideosResult>

  /** Get the user reviews for a movie. */
  @GET("/3/movie/{movie_id}/reviews")
  suspend fun movieReviews(@Path(MOVIE_ID) id: String): Response<ReviewsResult>

  /** Get the images that belong to a movie. */
  @GET("/3/movie/{movie_id}/images")
  suspend fun movieImages(@Path(MOVIE_ID) id: String): Response<ImagesResult>

  /** Get the cast and crew for a movie. */
  @GET("/3/movie/{movie_id}/credits")
  suspend fun movieCredits(@Path(MOVIE_ID) id: String): Response<MoviesDto>

  /** Rate a movie. */
  @POST("/3/movie/{movie_id/rating}")
  suspend fun rateMovie(@Path(MOVIE_ID) id: String): Response<MoviesDto>

  /** Remove your rating for a movie. */
  @DELETE("/3/movie/{movie_id/rating}")
  suspend fun deleteRating(@Path(MOVIE_ID) id: String): Response<MoviesDto>

  companion object {
    const val PAGE = "page"
    const val CATEGORY = "category"
    private const val MOVIE_ID = "movie_id"
  }
}