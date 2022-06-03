package com.freddydev.ciney.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.components.CineyBottomBar
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.navigation.CineyNavGraph
import com.freddydev.ciney.ui.theme.CineyTheme
import com.freddydev.ciney.util.WindowSize
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CineyApp(windowSize: WindowSize, finishActivity: () -> Unit) {
  CineyTheme {
    ProvideWindowInsets {
      // val systemUiController = rememberSystemUiController()
      // val darkIcons = MaterialTheme.colors.isLight
//      SideEffect {
//        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
//      }

      val tabs = remember {
        listOf(
          BottomNavItem.Movie,
          BottomNavItem.TvShow,
          BottomNavItem.Search,
          BottomNavItem.Favorite,
          BottomNavItem.Profile
        )
      }

      val navController = rememberNavController()

      Scaffold(
        bottomBar = { CineyBottomBar(navController = navController, tabs) }
      ) { innerPaddingModifier ->
        CineyNavGraph(
          navController = navController,
          windowSize = windowSize,
          modifier = Modifier.padding(innerPaddingModifier),
          finishActivity = finishActivity
        )
      }
    }
  }
}
