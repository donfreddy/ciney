package com.freddydev.ciney.domain.model.tvshow

data class TvShowResult(
  val page: Int,
  val tvShows: List<TvShow>,
  val total_pages: Int,
  val total_results: Int
)