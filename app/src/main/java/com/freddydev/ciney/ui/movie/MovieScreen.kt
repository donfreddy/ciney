package com.freddydev.ciney.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.freddydev.ciney.R
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.ui.components.CenterTopAppBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@Composable
fun MovieScreen() {
    MovieContent()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieContent() {
  val movieViewModel = hiltViewModel<MovieViewModel>()

  val movies: List<Movie>? by movieViewModel.getNowPlaying().observeAsState(initial = null)
  // val movie: List<Movie>? by movieViewModel.getLatestMovie.observeAsState(initial = null)

 //  println("### MovieScreen: ${movie?.size}")

  val text: String by movieViewModel.text.observeAsState(initial = "")

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = text,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.h6
      )
    }
}

