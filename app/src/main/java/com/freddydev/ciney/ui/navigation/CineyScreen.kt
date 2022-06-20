package com.freddydev.ciney.ui.navigation

import androidx.navigation.NavHostController

sealed class CineyScreen(val route: String) {
  object First : CineyScreen("first")
  object Main : CineyScreen("main")
  object MovieDetail : CineyScreen("movie/{movieId}") {
    fun createRoute(movieId: Int) = "movie/$movieId"
  }

  // Media can be movie or tvshow
  object MediaVideos : CineyScreen("media/{mediaId}/videos") {
    fun createRoute(mediaId: Int) = "media/$mediaId/videos"
  }

  object TvShowDetail : CineyScreen("tv/{movieId}")
  object PersonDetail : CineyScreen("person/{movieId}")
}

sealed class MainScreens(val route: String) {
  object Home : MainScreens("home")
  object Movie : MainScreens("movie")
  object TvShow : MainScreens("tv")
  object Discover : MainScreens("Discover")
  object Profile : MainScreens("profile")
}

class Actions(navHostController: NavHostController) {
  val openMovieDetails: (Int) -> Unit = { movieId ->
    navHostController.navigate(CineyScreen.MovieDetail.createRoute(movieId))
  }

  val openMediaVideos: (Int) -> Unit = { mediaId ->
    navHostController.navigate(CineyScreen.MediaVideos.createRoute(mediaId))
  }

  val navigateBack: () -> Unit = {
    navHostController.navigateUp()
  }
}
