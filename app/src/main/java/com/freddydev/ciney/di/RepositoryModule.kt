package com.freddydev.ciney.di

import com.freddydev.ciney.data.repository.movie.MovieRepositoryImpl
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Singleton
  @Provides
  fun provideMovieRepository(
    movieRemoteDatasource: MovieRemoteDatasource,
    movieLocalDataSource: MovieLocalDatasource,
  ): MovieRepository {
    return MovieRepositoryImpl(
      movieRemoteDatasource = movieRemoteDatasource,
      movieLocalDataSource = movieLocalDataSource
    )
  }
}