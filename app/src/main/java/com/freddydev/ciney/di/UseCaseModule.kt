package com.freddydev.ciney.di

import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.repository.TrendingRepository
import com.freddydev.ciney.domain.use_case.movie.get_movie.GetMovieUseCase
import com.freddydev.ciney.domain.use_case.movie.get_movies.GetMoviesUseCase
import com.freddydev.ciney.domain.use_case.get_trending.GetTrendingUseCase
import com.freddydev.ciney.domain.use_case.movie.get_movie_credits.GetMovieCreditsUseCase
import com.freddydev.ciney.domain.use_case.movie.get_movie_images.GetMovieImagesUseCase
import com.freddydev.ciney.domain.use_case.movie.get_movie_reviews.GetMovieReviewsUseCase
import com.freddydev.ciney.domain.use_case.movie.get_movie_videos.GetMovieVideosUseCase
import com.freddydev.ciney.domain.use_case.movie.get_recommended_movies.GetRecommendedMoviesUseCase
import com.freddydev.ciney.domain.use_case.movie.get_similar_movies.GetSimilarMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

  // -------------------
  // MOVIES USE CASES
  // -------------------

  @Provides
  @ViewModelScoped
  fun provideGetMoviesUseCase(
    movieRepository: MovieRepository,
  ): GetMoviesUseCase {
    return GetMoviesUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetMovieUseCase(
    movieRepository: MovieRepository,
  ): GetMovieUseCase {
    return GetMovieUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetSimilarMoviesUseCase(
    movieRepository: MovieRepository,
  ): GetSimilarMoviesUseCase {
    return GetSimilarMoviesUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetRecommendedUseCase(
    movieRepository: MovieRepository,
  ): GetRecommendedMoviesUseCase {
    return GetRecommendedMoviesUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetMovieVideosUseCase(
    movieRepository: MovieRepository,
  ): GetMovieVideosUseCase {
    return GetMovieVideosUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideReviewsUseCase(
    movieRepository: MovieRepository,
  ): GetMovieReviewsUseCase {
    return GetMovieReviewsUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetMovieCreditsUseCase(
    movieRepository: MovieRepository,
  ): GetMovieCreditsUseCase {
    return GetMovieCreditsUseCase(movieRepos = movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetMovieImagesUseCase(
    movieRepository: MovieRepository,
  ): GetMovieImagesUseCase {
    return GetMovieImagesUseCase(movieRepos = movieRepository)
  }

  // -------------------
  // TV SHOW USE CASES
  // -------------------

  // -------------------
  // TRENDING USE CASES
  // -------------------

  @Provides
  @ViewModelScoped
  fun provideGetTrendingUseCase(trendingRepository: TrendingRepository): GetTrendingUseCase {
    return GetTrendingUseCase(trendingRepos = trendingRepository)
  }
}