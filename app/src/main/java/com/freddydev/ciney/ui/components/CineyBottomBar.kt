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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.navigation.BottomNavItem

@Composable
fun CineyBottomBar(navController: NavController, tabs: List<BottomNavItem>) {

  BottomNavigation(
    backgroundColor = colorResource(id = R.color.blue),
    contentColor = Color.White,
    elevation = 8.dp,
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    tabs.forEach { tab ->
      BottomNavigationItem(
        icon = { Icon(painter = painterResource(tab.icon), contentDescription = tab.route) },
        label = {
          Text(
            text = stringResource(id = tab.titleResId),
            softWrap = false
          )
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
        alwaysShowLabel = true,
        selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true,
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