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
  startDestination: String = CineyScreen.Main.route,
  finishActivity: () -> Unit = {},
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
        modifier = modifier,
      )
    }

    // Detail screen
  }
}