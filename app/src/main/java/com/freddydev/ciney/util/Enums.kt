package com.freddydev.ciney.util

enum class EnumCategory(val value: String) {
  NOW_PLAYING(value = "now_playing"),
  UPCOMING(value = "upcoming"),
  POPULAR(value = "popular"),
  TOP_RATED(value = "top_rated"),
}

enum class EnumMediaType(val value: String) {
  ALL(value = "all"),
  MOVIE(value = "movie"),
  TV(value = "tv"),
  PERSON(value = "person"),
}

enum class EnumsTimeWindow(val value: String) {
  DAY(value = "day"),
  WEEK(value = "week")
}