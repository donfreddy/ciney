package com.freddydev.ciney.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.ui.components.CineyBottomBar
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.navigation.CineyNavGraph
import com.freddydev.ciney.ui.theme.BackgroundColor
import com.freddydev.ciney.ui.theme.CineyTheme
import com.freddydev.ciney.util.WindowSize
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CineyApp(windowSize: WindowSize) {
  CineyTheme {
    ProvideWindowInsets(
      consumeWindowInsets = false,
    ) {
      val systemUiController = rememberSystemUiController()
      val navController = rememberNavController()
      SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
        systemUiController.setNavigationBarColor(BackgroundColor)
      }

      val tabs = remember {
        listOf(
          BottomNavItem.Home,
          BottomNavItem.Movie,
          BottomNavItem.TvShow,
          BottomNavItem.Discover,
          BottomNavItem.Profile
        )
      }

      Scaffold(
        bottomBar = { CineyBottomBar(navController = navController, tabs = tabs) },
      ) {
        CineyNavGraph(
          navController = navController,
          windowSize = windowSize,
        )
      }
    }
  }
}
