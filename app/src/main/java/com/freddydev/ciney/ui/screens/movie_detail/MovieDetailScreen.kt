package com.freddydev.ciney.ui.screens.movie_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.freddydev.ciney.domain.model.movie.MovieDetail

@Composable
fun MovieDetailScreen(
  viewModel: MovieDetailViewModel = hiltViewModel()
) {
  val state = viewModel.movieDetailState.value

  Box(modifier = Modifier.fillMaxSize()) {

    state.movie?.let { MovieDetailContent(movie = it) }

    if (state.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
    }

    if (state.error.isNotBlank()) {
      Text(
        text = state.error,
        color = MaterialTheme.colors.error,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp)
          .align(Alignment.Center)
      )
    }
  }
}

@Composable
fun MovieDetailContent(
  movie: MovieDetail
) {
  Column(
    modifier = Modifier
      .verticalScroll(rememberScrollState())
  ) {
    Text(
      text = movie.title,
    )
    Text(
      text = movie.original_title,
    )
    Text(
      text = movie.tagline,
    )
  }
}
