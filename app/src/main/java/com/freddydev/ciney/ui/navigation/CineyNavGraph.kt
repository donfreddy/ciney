package com.freddydev.ciney.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.freddydev.ciney.util.WindowSize

@Composable
fun CineyNavGraph(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
  windowSize: WindowSize,
  startDestination: String = Screens.Main.route,
  finishActivity: () -> Unit = {},
) {
  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {
    // First screen should be implemented here

    // Main screens (movie, tv, search, settings)
    navigation(
      route = Screens.Main.route,
      startDestination = MainScreens.Movie.route,
    ) {
      bottomNaGraph(
        navController = navController,
        windowSize = windowSize,
        modifier = modifier,
      )
    }

    // Detail screen
  }
}

sealed class Screens(val route: String) {
  object First : Screens("first")
  object Main : Screens("main")
  object MovieDetail : Screens("movie/{movieId}")
  object TvShowDetail : Screens("tv/{movieId}")
  object PersonDetail : Screens("person/{movieId}")


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
  object Movie : MainScreens("movie")
  object TvShow : MainScreens("tv")
  object Search : MainScreens("search")
  object Favorite : MainScreens("favorite")
  object Profile : MainScreens("profile")

  fun withArgs(vararg args: String): String {
    return buildString {
      append(route)
      args.forEach { arg ->
        append("/$arg")
      }
    }
  }
}
