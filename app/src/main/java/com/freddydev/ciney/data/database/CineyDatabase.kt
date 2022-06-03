package com.freddydev.ciney.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.freddydev.ciney.data.database.converters.IntegerListConverter
import com.freddydev.ciney.data.database.converters.StringListConverter
import com.freddydev.ciney.data.database.dao.MovieDao
import com.freddydev.ciney.domain.model.movie.Movie

@Database(
  entities = [Movie::class],
  version = 1,
  exportSchema = false
)
@TypeConverters(
  value = [
    StringListConverter::class,
    IntegerListConverter::class
  ]
)
abstract class CineyDatabase : RoomDatabase() {
  abstract fun movieDao(): MovieDao
}