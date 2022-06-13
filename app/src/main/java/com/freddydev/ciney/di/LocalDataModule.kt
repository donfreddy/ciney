package com.freddydev.ciney.di

import com.freddydev.ciney.data.database.dao.MovieDao
import com.freddydev.ciney.data.database.dao.TrendingDao
import com.freddydev.ciney.data.repository.movie.data_source.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.data_source_impl.MovieLocalDataSourceImpl
import com.freddydev.ciney.data.repository.trenting.data_source.TrendingLocalDatasource
import com.freddydev.ciney.data.repository.trenting.data_source_impl.TrendingLocalDataSourceImpl
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
  fun provideTrendingLocalDataSource(trendingDao: TrendingDao): TrendingLocalDatasource {
    return TrendingLocalDataSourceImpl(trendingDao = trendingDao)
  }

  @Singleton
  @Provides
  fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource {
    return MovieLocalDataSourceImpl(movieDao = movieDao)
  }
}