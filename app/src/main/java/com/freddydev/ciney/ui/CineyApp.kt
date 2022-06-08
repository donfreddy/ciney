package com.freddydev.ciney.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.components.CenterTopAppBar
import com.freddydev.ciney.ui.components.CineyBottomBar
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.navigation.CineyNavGraph
import com.freddydev.ciney.ui.navigation.MainScreens
import com.freddydev.ciney.ui.theme.ChineseBlack
import com.freddydev.ciney.ui.theme.CineyTheme
import com.freddydev.ciney.util.WindowSize
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CineyApp(windowSize: WindowSize, finishActivity: () -> Unit) {
  CineyTheme {
    ProvideWindowInsets {
      val systemUiController = rememberSystemUiController()
      val navController = rememberNavController()
      SideEffect {
        systemUiController.setSystemBarsColor(ChineseBlack, darkIcons = false)
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

      // show top bar only on movie and tv show screens
      val destination = navController.currentBackStackEntryAsState().value?.destination
      val showTopBar = destination?.route?.let { route ->
        route == MainScreens.Movie.route || route == MainScreens.TvShow.route
      } ?: false

      // check if we are on the movie
      val isMovieScreen = destination?.route == MainScreens.Movie.route

      Scaffold(
        topBar = {
          if (showTopBar) AppBar(isMovieScreen = isMovieScreen)
        },
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

@Composable
fun AppBar(isMovieScreen: Boolean) {
  CenterTopAppBar(
    title = {
      Text(
        text = stringResource(id = if (isMovieScreen) R.string.title_movie else R.string.title_tvshow),
        style = MaterialTheme.typography.h6,
      )
    },
    elevation = 0.dp,
    actions = {
      IconButton(onClick = {}) {
        Icon(
          painter = painterResource(id = R.drawable.ic_search),
          contentDescription = null
        )
      }
    }
  )
}
