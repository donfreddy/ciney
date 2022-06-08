package com.freddydev.ciney.ui.navigation

sealed class CineyScreen(val route: String) {
  object First : CineyScreen("first")
  object Main : CineyScreen("main")
  object MovieDetail : CineyScreen("movie/{movieId}")
  object TvShowDetail : CineyScreen("tv/{movieId}")
  object PersonDetail : CineyScreen("person/{movieId}")


  fun withArgs(vararg args: String): String {
    return buildString {
      append(route)
      args.forEach { arg ->
        append("/$arg")
      }
    }
  }
}

sealed class MainScreens(val route: String) {
  object Home : MainScreens("home")
  object Movie : MainScreens("movie")
  object TvShow : MainScreens("tv")
  object Discover : MainScreens("Discover")
  object Profile : MainScreens("profile")
}
