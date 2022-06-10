package com.freddydev.ciney.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.movie.components.MovieCard
import com.freddydev.ciney.ui.components.RowTitle
import com.freddydev.ciney.ui.home.components.AppBAr
import com.freddydev.ciney.ui.home.components.TextInputField
import com.freddydev.ciney.ui.home.components.TrendingCard
import com.freddydev.ciney.ui.movie.MovieState
import com.freddydev.ciney.ui.movie.MovieViewModel
import com.freddydev.ciney.util.EnumMediaType
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsPadding


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier
      .verticalScroll(scrollState)
      .statusBarsPadding(),
  ) {
    HomeContent()
    Spacer(Modifier.navigationBarsHeight(additional = 56.dp))
  }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeContent(
  modifier: Modifier = Modifier
) {
  // View models
  val homeViewModel = hiltViewModel<HomeViewModel>()
  val movieViewModel = hiltViewModel<MovieViewModel>()

  var search by remember { mutableStateOf("") }

  val trendingState = homeViewModel.trendingState.value
  val popularMoviesState = movieViewModel.popularMoviesState.value

  Column(
    modifier = modifier,
  ) {
    AppBAr()

    Spacer(modifier = Modifier.height(20.dp))

    TextInputField(
      label = stringResource(R.string.text_search),
      value = search,
      onValueChanged = {
        search = it
      })

    // Trending Today/This Week
    TrendingSection(trendingState = trendingState)

    // What's Popular in Theaters
    PopularInTheatersSection(popularMoviesState = popularMoviesState)

    // What's Popular on TV
    PopularOnTvSection(trendingState = trendingState)

    // Latest Trailers on TV
  }
}

@Composable
fun TrendingSection(
  trendingState: TrendingState
) {
  if (trendingState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  trendingState.trending?.let { trending ->
    Column() {
      Spacer(modifier = Modifier.height(10.dp))
      RowTitle(title = "Trending Today")
      LazyRow() {
        items(trending.size) { index ->
          TrendingCard(
            trending = trending[index],
            selectPoster = {
//              when (trending[index].media_type) {
//                is EnumMediaType.MOVIE.value -> {}
//                is EnumMediaType.TV.value -> {}
//                is EnumMediaType.PERSON.value -> {}
//              }
            }
          )
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (trendingState.error.isNotBlank()) {
    Text(
      text = trendingState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = MaterialTheme.typography.h6
    )
  }
}

@Composable
fun PopularInTheatersSection(
  popularMoviesState: MovieState
) {
  if (popularMoviesState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  popularMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Popular in Theaters")
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
fun PopularOnTvSection(
  trendingState: TrendingState
) {
  if (trendingState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  trendingState.trending?.let { trending ->
    Column() {
      RowTitle(title = "Popular on TV")
      LazyRow() {
        items(trending.size) { index ->
          TrendingCard(trending = trending[index], selectPoster = {})
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
    }
  }

  if (trendingState.error.isNotBlank()) {
    Text(
      text = trendingState.error,
      textAlign = TextAlign.Center,
      color = Color.Red,
      style = typography.h6
    )
  }
}
