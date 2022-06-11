package com.freddydev.ciney.di

import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.repository.TrendingRepository
import com.freddydev.ciney.domain.usecase.movie.GetMovieDetailUseCase
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
import com.freddydev.ciney.domain.usecase.trending.GetTrendingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

  // -------------------
  // MOVIES
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
  fun provideGetMovieDetailUseCase(
    movieRepository: MovieRepository,
  ): GetMovieDetailUseCase {
    return GetMovieDetailUseCase(movieRepository = movieRepository)
  }

  // -------------------
  // TV SHOW
  // -------------------

  // -------------------
  // TRENDING ITEMS
  // -------------------

  @Provides
  @ViewModelScoped
  fun provideGetTrendingUseCase(trendingRepository: TrendingRepository): GetTrendingUseCase {
    return GetTrendingUseCase(trendingRepos = trendingRepository)
  }
}