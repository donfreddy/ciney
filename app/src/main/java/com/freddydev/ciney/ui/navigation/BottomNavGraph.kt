package com.freddydev.ciney.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.movie.MovieScreen
import com.freddydev.ciney.util.WindowSize

fun NavGraphBuilder.bottomNaGraph(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  windowSize: WindowSize,
  onSelected: (Long, NavBackStackEntry) -> Unit = { _, _ -> }
) {

  composable(route = BottomNavItem.Movie.route) {
    MovieScreen()
  }

  composable(route = BottomNavItem.TvShow.route) {
    TvShowScreen()
  }

  composable(route = BottomNavItem.Search.route) {
    SearchScreen()
  }

  composable(route = BottomNavItem.Favorite.route) {
    FavoriteScreen()
  }

  composable(route = BottomNavItem.Profile.route) {
    ProfileScreen()
  }

}

sealed class BottomNavItem(
  val route: String,
  @StringRes val titleResId: Int,
  @DrawableRes val icon: Int,
) {
  object Movie : BottomNavItem(
    route = MainScreens.Movie.route,
    titleResId = R.string.title_movie,
    icon = R.drawable.ic_sharp_movie
  )

  object TvShow : BottomNavItem(
    route = MainScreens.TvShow.route,
    titleResId = R.string.title_tvshow,
    icon = R.drawable.ic_sharp_tv
  )

  object Search : BottomNavItem(
    route = MainScreens.Search.route,
    titleResId = R.string.title_search,
    icon = R.drawable.ic_search
  )

  object Favorite : BottomNavItem(
    route = MainScreens.Favorite.route,
    titleResId = R.string.title_favorites,
    icon = R.drawable.ic_favorite
  )

  object Profile : BottomNavItem(
    route = MainScreens.Profile.route,
    titleResId = R.string.title_profile,
    icon = R.drawable.ic_round_account_circle
  )
}


@Composable
fun TvShowScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "TvShow Screen",
      modifier = Modifier.align(Alignment.CenterHorizontally),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h6

    )
  }
}

@Composable
fun SearchScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Search Screen",
      modifier = Modifier.align(Alignment.CenterHorizontally),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h6

    )
  }
}

@Composable
fun FavoriteScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Favorite Screen",
      modifier = Modifier.align(Alignment.CenterHorizontally),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h6

    )
  }
}

@Composable
fun ProfileScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Profile Screen",
      modifier = Modifier.align(Alignment.CenterHorizontally),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h6

    )
  }
}



