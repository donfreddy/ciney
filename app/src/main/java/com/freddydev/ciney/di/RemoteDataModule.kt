package com.freddydev.ciney.di

import com.freddydev.ciney.data.api.ApiService
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDataSource
import com.freddydev.ciney.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

  @Singleton
  @Provides
  fun provideRemoteMovieDataSource(apiService: ApiService): MovieRemoteDataSource {
    return MovieRemoteDataSourceImpl(apiService = apiService)
  }
}