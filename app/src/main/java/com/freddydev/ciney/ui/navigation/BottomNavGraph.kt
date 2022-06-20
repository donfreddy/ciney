package com.freddydev.ciney.ui.navigation

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
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
import com.freddydev.ciney.ui.screens.home.HomeScreen
import com.freddydev.ciney.ui.screens.movie.MovieScreen
import com.freddydev.ciney.ui.screens.profile.ProfileScreen
import com.freddydev.ciney.ui.screens.tvshow.TvShowScreen
import com.freddydev.ciney.util.WindowSize

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.bottomNaGraph(
  navController: NavHostController,
  windowSize: WindowSize,
  actions: Actions,
  onSelected: (Long, NavBackStackEntry) -> Unit = { _, _ -> }
) {

  composable(route = BottomNavItem.Home.route) {
    HomeScreen(
      openMovieDetails = actions.openMovieDetails
    )
  }

  composable(route = BottomNavItem.Movie.route) {
    MovieScreen(
      openMovieDetails = actions.openMovieDetails
    )
  }

  composable(route = BottomNavItem.TvShow.route) {
    TvShowScreen()
  }

  composable(route = BottomNavItem.Discover.route) {
    DiscoverScreen()
  }

  composable(route = BottomNavItem.Profile.route) {
    ProfileScreen()
  }

}

sealed class BottomNavItem(
  val route: String,
  @StringRes val titleResId: Int,
  @DrawableRes val icon: Int,
  @DrawableRes val outlineIcon: Int = icon
) {

  object Home : BottomNavItem(
    route = MainScreens.Home.route,
    titleResId = R.string.title_home,
    icon = R.drawable.ic_home,
    outlineIcon = R.drawable.ic_home_outline
  )

  object Movie : BottomNavItem(
    route = MainScreens.Movie.route,
    titleResId = R.string.title_movie,
    icon = R.drawable.ic_film,
    outlineIcon = R.drawable.ic_film_outline
  )

  object TvShow : BottomNavItem(
    route = MainScreens.TvShow.route,
    titleResId = R.string.title_tvshow,
    icon = R.drawable.ic_tv,
    outlineIcon = R.drawable.ic_tv_outline
  )

  object Discover : BottomNavItem(
    route = MainScreens.Discover.route,
    titleResId = R.string.title_discover,
    icon = R.drawable.ic_compass,
    outlineIcon = R.drawable.ic_compass_outline
  )

  object Profile : BottomNavItem(
    route = MainScreens.Profile.route,
    titleResId = R.string.title_profile,
    icon = R.drawable.ic_round_account_circle,
    outlineIcon = R.drawable.ic_outline_account_circle
  )
}


@Composable
fun PersonScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Person Screen",
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
fun DiscoverScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Discover Screen",
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
