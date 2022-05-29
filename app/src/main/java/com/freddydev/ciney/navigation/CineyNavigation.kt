package com.freddydev.ciney.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.ui.main.MainScreen

@Composable
fun CineyNavigation() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = CineyScreens.Home.route
  ) {
    composable(route = CineyScreens.Home.route) {
      MainScreen()
    }
  }
}