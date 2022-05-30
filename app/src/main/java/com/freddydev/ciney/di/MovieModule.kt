package com.freddydev.ciney.di

import com.freddydev.ciney.domain.usecase.movie.GetNowPlayingMoviesUseCase
import com.freddydev.ciney.ui.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieModule {

  @Singleton
  @Provides
  fun provideMovieViewModelFactory(
    getNowPlayingMovies: GetNowPlayingMoviesUseCase
  ): MovieViewModelFactory {
    return MovieViewModelFactory(getNowPlayingMovies = getNowPlayingMovies)
  }
}