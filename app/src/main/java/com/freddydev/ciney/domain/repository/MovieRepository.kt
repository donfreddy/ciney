package com.freddydev.ciney.domain.repository

import com.freddydev.ciney.domain.model.image.ImagesResult
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.review.Review
import com.freddydev.ciney.domain.model.video.Video
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

  fun getMovies(category: String, page: Int): Flow<Resource<List<Movie>>>

  fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>>

  fun getSimilarMovies(movieId: Int, page: Int): Flow<Resource<List<Movie>>>

  fun getRecommendedMovies(movieId: Int, page: Int): Flow<Resource<List<Movie>>>

  fun getMovieVideos(movieId: Int): Flow<Resource<List<Video>>>

  fun getMovieReviews(movieId: Int): Flow<Resource<List<Review>>>

  fun getMovieImages(movieId: Int): Flow<Resource<ImagesResult>>
}