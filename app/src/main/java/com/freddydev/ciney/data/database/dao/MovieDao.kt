package com.freddydev.ciney.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.freddydev.ciney.domain.model.movie.Movie

@Dao
interface MovieDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveMovies(movies: List<Movie>)

  @Query("SELECT *  FROM movies")
  suspend fun getMovies(): List<Movie>

  @Query("DELETE FROM movies")
  suspend fun deleteAllMovies()
}