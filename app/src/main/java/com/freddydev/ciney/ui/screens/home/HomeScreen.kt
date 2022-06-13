package com.freddydev.ciney.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.freddydev.ciney.ui.components.RowTitle
import com.freddydev.ciney.ui.screens.home.components.AppBAr
import com.freddydev.ciney.ui.screens.home.components.TextInputField
import com.freddydev.ciney.ui.screens.home.components.TrendingCard
import com.freddydev.ciney.ui.screens.movie.MovieState
import com.freddydev.ciney.ui.screens.movie.MovieViewModel
import com.freddydev.ciney.ui.screens.movie.components.MovieCard
import com.freddydev.ciney.util.EnumMediaType
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsPadding


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
  showMovieDetailPage: (movieId: Int) -> Unit
) {

  Column(
    modifier = Modifier
      .verticalScroll(rememberScrollState())
      .statusBarsPadding(),
  ) {
    HomeContent(
      showMovieDetailPage = { showMovieDetailPage(it) }
    )
    Spacer(Modifier.navigationBarsHeight(additional = 56.dp))
  }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeContent(
  modifier: Modifier = Modifier,
  showMovieDetailPage: (movieId: Int) -> Unit
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
    TrendingSection(
      trendingState = trendingState,
      showMovieDetailPage = { showMovieDetailPage(it) }
    )

    // What's Popular in Theaters
    PopularInTheatersSection(
      popularMoviesState = popularMoviesState,
      showMovieDetailPage = { showMovieDetailPage(it) }
    )

    // What's Popular on TV
    PopularOnTvSection(trendingState = trendingState)

    // Latest Trailers on TV
  }
}

@Composable
fun TrendingSection(
  trendingState: TrendingState,
  showMovieDetailPage: (movieId: Int) -> Unit
) {
  if (trendingState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  trendingState.trending?.let { trending ->
    Column() {
      Spacer(modifier = Modifier.height(10.dp))
      RowTitle(title = "Trending Today")
      LazyRow {
        items(trending.size) { index ->
          TrendingCard(
            trending = trending[index],
            selectPoster = { id, mediaType ->
              when (mediaType) {
                EnumMediaType.MOVIE.value -> showMovieDetailPage(id)
                EnumMediaType.TV.value -> {}
                EnumMediaType.PERSON.value -> {}
              }
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
  popularMoviesState: MovieState,
  showMovieDetailPage: (movieId: Int) -> Unit
) {
  if (popularMoviesState.isLoading) {
    CircularProgressIndicator(modifier = Modifier)
  }

  popularMoviesState.movies?.let { movies ->
    Column() {
      RowTitle(title = "Popular in Theaters")
      LazyRow() {
        items(movies.size) { index ->
          MovieCard(
            movie = movies[index],
            selectPoster = { movieId ->
              showMovieDetailPage(movieId)
            }
          )
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
          TrendingCard(trending = trending[index], selectPoster = { _, _ -> {} })
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
