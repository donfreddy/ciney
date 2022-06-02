package com.freddydev.ciney.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.freddydev.ciney.ui.movie.MovieScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = BottomNavItem.Movie.route
  ) {
    composable(BottomNavItem.Movie.route) {
      MovieScreen()
    }

    composable(BottomNavItem.TvShow.route) {
      TvShowScreen()
    }

    composable(BottomNavItem.Search.route) {
      SearchScreen()
    }

    composable(BottomNavItem.Favorite.route) {
      FavoriteScreen()
    }

    composable(BottomNavItem.Profile.route) {
      ProfileScreen()
    }
  }

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



