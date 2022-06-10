package com.freddydev.ciney.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.freddydev.ciney.ui.movie.components.MovieCard
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun MovieScreen() {
  MovieContent()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieContent() {
  val movieViewModel = hiltViewModel<MovieViewModel>()
  val popularMoviesState = movieViewModel.popularMoviesState.value

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    if (popularMoviesState.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
    }

    popularMoviesState.movies?.let { movies ->
      LazyRow {
        items(movies.size) { index ->
          MovieCard(movie = movies[index], selectPoster = {})
        }
      }
    }

    if (popularMoviesState.error.isNotBlank()) {
      Text(
        text = popularMoviesState.error,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        color = Color.Red,
        style = MaterialTheme.typography.h6
      )
    }
  }
}

