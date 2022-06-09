package com.freddydev.ciney.ui.components

import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.theme.DavyGrey
import com.google.accompanist.insets.*

@Composable
fun CineyBottomBar(navController: NavController, tabs: List<BottomNavItem>) {

  BottomNavigation(
    backgroundColor = MaterialTheme.colors.background,
    contentColor = Color.White,
    elevation = 12.dp,
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

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
        unselectedContentColor = DavyGrey,
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