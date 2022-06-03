package com.freddydev.ciney.di

import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.movie.GetNowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

  // -------------------
  // MOVIES
  // -------------------

  @Provides
  @ViewModelScoped
  fun provideGetNowPlayingMoviesUseCase (
    movieRepository: MovieRepository,
    page: Int?
  ): GetNowPlayingMoviesUseCase {
    return GetNowPlayingMoviesUseCase(movieRepos = movieRepository, page = page)
  }
}