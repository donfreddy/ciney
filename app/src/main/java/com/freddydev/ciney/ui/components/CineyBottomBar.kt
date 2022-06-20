package com.freddydev.ciney.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.navigation.CineyScreen
import com.freddydev.ciney.ui.navigation.MainScreens
import com.freddydev.ciney.ui.theme.White38
import com.google.accompanist.insets.*

@Composable
fun CineyBottomBar(navController: NavController, tabs: List<BottomNavItem>) {

  // State of bottomBar, set state to false, if current page route is a detail page
  val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

  // Subscribe to navBackStackEntry, required to get current route
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  when (currentDestination?.route) {
    MainScreens.Home.route -> bottomBarState.value = true
    MainScreens.Movie.route -> bottomBarState.value = true
    MainScreens.TvShow.route -> bottomBarState.value = true
    MainScreens.Discover.route -> bottomBarState.value = true
    MainScreens.Profile.route -> bottomBarState.value = true
    CineyScreen.MovieDetail.route -> bottomBarState.value = false
    CineyScreen.MediaVideos.route -> bottomBarState.value = false
  }

  AnimatedVisibility(
    visible = bottomBarState.value,
    enter = slideInVertically(initialOffsetY = { it }),
    exit = slideOutVertically(targetOffsetY = { it }),
  ) {
    BottomNavigation(
      backgroundColor = MaterialTheme.colors.background,
      contentColor = Color.White,
      elevation = 0.dp,
      modifier = Modifier.systemBarsPadding()
    ) {
      tabs.forEach { tab ->
        val isSelected = currentDestination?.hierarchy?.any { it.route == tab.route } == true
        BottomNavigationItem(
          icon = {
            Icon(
              painter = painterResource(id = if (isSelected) tab.icon else tab.outlineIcon),
              contentDescription = tab.route
            )
          },
          label = {
            Text(
              text = stringResource(id = tab.titleResId),
              fontSize = 11.sp,
              softWrap = false
            )
          },
          selectedContentColor = MaterialTheme.colors.primary,
          unselectedContentColor = White38,
          alwaysShowLabel = false,
          selected = isSelected,
          onClick = {
            navController.navigate(tab.route) {
              navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                  saveState = true
                }
              }
              launchSingleTop = true
              restoreState = true
            }
          }
        )
      }
    }
  }
}