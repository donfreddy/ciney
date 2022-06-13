package com.freddydev.ciney.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.freddydev.ciney.ui.screens.movie_detail.MovieDetailScreen
import com.freddydev.ciney.util.WindowSize

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CineyNavGraph(
  navController: NavHostController = rememberNavController(),
  windowSize: WindowSize,
  startDestination: String = CineyScreen.Main.route,
) {
  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {
    // First screen should be implemented here

    // Main screens (movie, tv, search, settings)
    navigation(
      route = CineyScreen.Main.route,
      startDestination = MainScreens.Movie.route,
    ) {
      bottomNaGraph(
        navController = navController,
        windowSize = windowSize,
      )
    }

    // Detail screen
    composable(route = CineyScreen.MovieDetail.route) {
      MovieDetailScreen()
    }
  }
}