package com.freddydev.ciney.di

import android.content.Context
import com.freddydev.ciney.data.repository.movie.MovieRepositoryImpl
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.data.repository.trenting.TrendingRepositoryImpl
import com.freddydev.ciney.data.repository.trenting.datasource.TrendingLocalDatasource
import com.freddydev.ciney.data.repository.trenting.datasource.TrendingRemoteDatasource
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.repository.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Singleton
  @Provides
  fun provideTrendingRepository(
    trendingRemoteDatasource: TrendingRemoteDatasource,
    trendingLocalDatasource: TrendingLocalDatasource
  ): TrendingRepository {
    return TrendingRepositoryImpl(
      trendingRemoteDatasource = trendingRemoteDatasource,
      trendingLocalDatasource = trendingLocalDatasource
    )
  }

  @Singleton
  @Provides
  fun provideMovieRepository(
    @ApplicationContext context: Context,
    movieRemoteDatasource: MovieRemoteDatasource,
    movieLocalDataSource: MovieLocalDatasource,
  ): MovieRepository {
    return MovieRepositoryImpl(
      context = context,
      movieRemoteDatasource = movieRemoteDatasource,
      movieLocalDataSource = movieLocalDataSource
    )
  }
}