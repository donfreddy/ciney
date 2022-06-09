package com.freddydev.ciney.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.freddydev.ciney.domain.model.trending.Trending

@Dao
interface TrendingDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveTrending(trending: List<Trending>)

  @Query("SELECT *  FROM trending")
  suspend fun getTrending(): List<Trending>

  @Query("DELETE FROM trending")
  suspend fun deleteTrending()
}