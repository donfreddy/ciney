package com.freddydev.ciney.data.api.services

import com.freddydev.ciney.data.dto.trending.TrendingResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrendingService {

  /**
   * Get the daily or weekly trending movie,tvshow and person.
   */
  @GET("/3/trending/{media_type}/{time_window}")
  suspend fun getTrending(
    @Path(MEDIA_TYPE) mediaType: String,
    @Path(TIME_WINDOW) timeWindow: String,
    @Query(PAGE) page: Int
  ): Response<TrendingResultDto>

  companion object {
    const val PAGE = "page"
    const val MEDIA_TYPE = "media_type"
    private const val TIME_WINDOW = "time_window"
  }
}
