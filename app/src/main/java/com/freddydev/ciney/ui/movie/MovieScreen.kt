package com.freddydev.ciney.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun MovieScreen() {
  MovieContent()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieContent() {
  val movieViewModel = hiltViewModel<MovieViewModel>()
  val latestMovieState = movieViewModel.latestMovieState.value

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    if (latestMovieState.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
    }

    latestMovieState.movie?.let { movie ->
      Text(
        text = movie.original_title,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.h6
      )
    }

    if (latestMovieState.error.isNotBlank()) {
      Text(
        text = latestMovieState.error,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        color = Color.Red,
        style = MaterialTheme.typography.h6
      )
    }
  }
}

