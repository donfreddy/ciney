package com.freddydev.ciney.ui.home

import com.freddydev.ciney.domain.model.trending.Trending

data class TrendingState(
  val isLoading: Boolean = false,
  val trending: List<Trending> ?= emptyList(),
  val error: String = ""
)