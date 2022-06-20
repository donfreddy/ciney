package com.freddydev.ciney.ui.screens.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.freddydev.ciney.ui.components.LoadingView
import com.freddydev.ciney.ui.components.RowTitle
import com.freddydev.ciney.ui.screens.movie.components.MovieCard
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun MovieScreen(
  openMovieDetails: (movieId: Int) -> Unit
) {
  Column(
    modifier = Modifier
      .verticalScroll(rememberScrollState())
      .statusBarsPadding(),
  ) {
    MovieContent()
    Spacer(Modifier.navigationBarsHeight(additional = 56.dp))
  }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieContent() {
  val movieViewModel = hiltViewModel<MovieViewModel>()
  val popularMoviesState = movieViewModel.popularMoviesState.value
  val nowPlayingMoviesState = movieViewModel.nowPlayingMoviesState.value
  val upcomingMoviesState = movieViewModel.upcomingMoviesState.value
  val topRatedMoviesState = movieViewModel.topRatedMoviesState.value


  Column(
    modifier = Modifier
  ) {

    // Popular Movies
    PopularMoviesSection(popularMoviesState)

    // Now Playing Movies
    NowPlayingMoviesSection(nowPlayingMoviesState)

    // Upcoming Movies
    UpcomingMoviesSection(upcomingMoviesState)

    // Top Rated Movies
    TopRatedMoviesSection(topRatedMoviesState)
  }
}

@Composable
fun PopularMoviesSection(
  popularMoviesState: MovieState
) {
  if (popularMoviesState.isLoading) {
    LoadingView(modifier = Modifier.fillMaxSize())
  }

  popularMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Popular")
      LazyRow() {
        items(movies.size) { index ->
          MovieCard(movie = movies[index], selectPoster = {})
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (popularMoviesState.error.isNotBlank()) {
    Text(
      text = popularMoviesState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = MaterialTheme.typography.h6
    )
  }
}

@Composable
fun NowPlayingMoviesSection(
  nowPlayingMoviesState: MovieState
) {
  if (nowPlayingMoviesState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  nowPlayingMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Now Playing")
      LazyRow() {
        items(movies.size) { index ->
          MovieCard(movie = movies[index], selectPoster = {})
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (nowPlayingMoviesState.error.isNotBlank()) {
    Text(
      text = nowPlayingMoviesState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = MaterialTheme.typography.h6
    )
  }
}

@Composable
fun UpcomingMoviesSection(
  upcomingMoviesState: MovieState
) {
  if (upcomingMoviesState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  upcomingMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Upcoming")
      LazyRow() {
        items(movies.size) { index ->
          MovieCard(movie = movies[index], selectPoster = {})
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (upcomingMoviesState.error.isNotBlank()) {
    Text(
      text = upcomingMoviesState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = MaterialTheme.typography.h6
    )
  }
}

@Composable
fun TopRatedMoviesSection(
  topRatedMoviesState: MovieState
) {
  if (topRatedMoviesState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  topRatedMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Top Rated")
      LazyRow() {
        items(movies.size) { index ->
          MovieCard(movie = movies[index], selectPoster = {})
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (topRatedMoviesState.error.isNotBlank()) {
    Text(
      text = topRatedMoviesState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = MaterialTheme.typography.h6
    )
  }
}

