package com.freddydev.ciney.di

import android.content.Context
import androidx.room.Room
import com.freddydev.ciney.data.database.CineyDatabase
import com.freddydev.ciney.data.database.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

  @Singleton
  @Provides
  fun provideCineyDataBase(@ApplicationContext context: Context): CineyDatabase {
    return Room.databaseBuilder(context, CineyDatabase::class.java, "Ciney.db")
      .allowMainThreadQueries()
      .build()
  }

  @Singleton
  @Provides
  fun provideMovieDao(cineyDatabase: CineyDatabase): MovieDao {
    return cineyDatabase.movieDao()
  }
}