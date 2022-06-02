package com.freddydev.ciney.ui.navigation


sealed class CineyScreens(val route: String) {
  object Movie : CineyScreens("movie")
  object TvShow : CineyScreens("tvshow")
  object Search : CineyScreens("search")
  object Favorite : CineyScreens("favorite")
  object Profile : CineyScreens("profile")

  fun withArgs(vararg args: String): String {
    return buildString {
      append(route)
      args.forEach { arg ->
        append("/$arg")
      }
    }
  }
}
