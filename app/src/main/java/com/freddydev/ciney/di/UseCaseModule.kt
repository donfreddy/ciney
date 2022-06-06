package com.freddydev.ciney.di

import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.movie.GetLatestMovieUseCase
import com.freddydev.ciney.domain.usecase.movie.GetMoviesUseCase
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
  fun provideGetLastMovieUseCase(movieRepository: MovieRepository): GetLatestMovieUseCase {
    return GetLatestMovieUseCase(movieRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideGetMoviesUseCase(
    movieRepository: MovieRepository,
  ): GetMoviesUseCase {
    return GetMoviesUseCase(movieRepos = movieRepository)
  }
}