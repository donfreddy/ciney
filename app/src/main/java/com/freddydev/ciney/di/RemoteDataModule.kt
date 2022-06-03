package com.freddydev.ciney.di

import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.data.api.services.MovieService
import com.freddydev.ciney.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

  @Singleton
  @Provides
  fun provideRemoteMovieDataSource(movieService: MovieService): MovieRemoteDatasource {
    return MovieRemoteDatasourceImpl(movieService = movieService)
  }
}