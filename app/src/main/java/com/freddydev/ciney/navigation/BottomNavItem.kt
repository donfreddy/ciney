package com.freddydev.ciney.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.freddydev.ciney.R

sealed class BottomNavItem(
  val route: String,
  @StringRes val titleResId: Int,
  val icon: ImageVector
) {
  object Home : BottomNavItem(
    route = CineyScreens.Home.route,
    titleResId = R.string.screen_title_home,
    icon = Icons.Default.Home
  )

  object Search : BottomNavItem(
    route = CineyScreens.Search.route,
    titleResId = R.string.screen_title_search,
    icon = Icons.Default.Search
  )
}