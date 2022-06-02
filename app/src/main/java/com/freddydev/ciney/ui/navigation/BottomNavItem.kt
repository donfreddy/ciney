package com.freddydev.ciney.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.freddydev.ciney.R

sealed class BottomNavItem(
  val route: String,
  @StringRes val titleResId: Int,
  @DrawableRes val icon: Int,
) {
  object Movie : BottomNavItem(
    route = CineyScreens.Movie.route,
    titleResId = R.string.title_movie,
    icon =  R.drawable.ic_sharp_movie
  )

  object TvShow : BottomNavItem(
    route = CineyScreens.TvShow.route,
    titleResId = R.string.title_tvshow,
    icon = R.drawable.ic_sharp_tv
  )

  object Search : BottomNavItem(
    route = CineyScreens.Search.route,
    titleResId = R.string.title_search,
    icon = R.drawable.ic_search
  )

  object Favorite : BottomNavItem(
    route = CineyScreens.Favorite.route,
    titleResId = R.string.title_favorites,
    icon = R.drawable.ic_favorite
  )

  object Profile : BottomNavItem(
    route = CineyScreens.Profile.route,
    titleResId = R.string.title_profile,
    icon = R.drawable.ic_round_account_circle
  )
}