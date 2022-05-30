package com.freddydev.ciney.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.freddydev.ciney.R
import com.freddydev.ciney.navigation.BottomNavItem

@Composable
fun BottomNavBar(navController: NavController) {
  val items = listOf(
    BottomNavItem.Movie,
    BottomNavItem.TvShow,
    BottomNavItem.Search,
    BottomNavItem.Favorite,
    BottomNavItem.Profile
  )

  BottomNavigation(
    backgroundColor = colorResource(id = R.color.blue),
    contentColor = Color.White
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    items.forEach { item ->
      BottomNavigationItem(
        icon = { Icon(painter = painterResource(item.icon), contentDescription = item.route) },
        label = {
          Text(
            text = stringResource(id = item.titleResId),
            softWrap = false
          )
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
        alwaysShowLabel = true,
        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
        onClick = {
          navController.navigate(item.route) {
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