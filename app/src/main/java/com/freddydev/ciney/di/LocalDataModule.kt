package com.freddydev.ciney.di

import com.freddydev.ciney.data.database.dao.MovieDao
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

  @Singleton
  @Provides
  fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource {
    return MovieLocalDataSourceImpl(movieDao = movieDao)
  }
}