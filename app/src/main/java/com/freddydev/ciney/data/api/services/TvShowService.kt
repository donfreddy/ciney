package com.freddydev.ciney.data.api.services

import com.freddydev.ciney.domain.model.tvshow.TvShowDetail
import com.freddydev.ciney.domain.model.tvshow.TvShowResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [Tv Show endpoints](https://developers.themoviedb.org/3/tv)
 */
interface TvShowService {

  /**
   * Get tv show list by airing today, on the air, popular or top rated.
   */
  @GET("/3/tv/{category}")
  suspend fun getTvShows(
    @Path(CATEGORY) category: String,
    @Query(PAGE) page: Int
  ): Response<TvShowResult>

  /** Get a single tv show by id. */
  @GET("/3/tv/{tv_id}")
  suspend fun getTvShow(@Path(TV_ID) tvId: Int): Response<TvShowDetail>

  companion object {
    const val PAGE = "page"
    const val CATEGORY = "category"
    private const val TV_ID = "tv_id"
  }
}