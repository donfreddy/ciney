package com.freddydev.ciney.ui.screens.movie_detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.freddydev.ciney.BuildConfig
import com.freddydev.ciney.R
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.ui.common.Constants.APP_BAR_COLLAPSED_HEIGHT
import com.freddydev.ciney.ui.common.Constants.APP_BAR_EXPANDED_HEIGHT
import com.freddydev.ciney.ui.theme.CineyShapes
import com.freddydev.ciney.ui.theme.DavyGrey
import com.freddydev.ciney.util.ExpandingText
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

@Composable
fun MovieDetailScreen(
  viewModel: MovieDetailViewModel = hiltViewModel()
) {
  val scrollState = rememberLazyListState()
  val state = viewModel.movieDetailState.value

  Box(modifier = Modifier.fillMaxSize()) {

    state.movie?.let { movie ->
      MovieDetailContent(movie = movie, scrollState = scrollState)
      ParallaxToolbar(movie = movie, scrollState = scrollState)
    }

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
fun ParallaxToolbar(
  movie: MovieDetail,
  scrollState: LazyListState
) {
  val imageHeight = APP_BAR_EXPANDED_HEIGHT - APP_BAR_COLLAPSED_HEIGHT
  val maxOffset =
    with(LocalDensity.current) { imageHeight.roundToPx() } - LocalWindowInsets.current.systemBars.layoutInsets.top
  val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)
  val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

  TopAppBar(
    contentPadding = PaddingValues(),
    backgroundColor = MaterialTheme.colors.background,
    modifier = Modifier
      .height(APP_BAR_EXPANDED_HEIGHT)
      .offset { IntOffset(x = 0, y = -offset) },
    elevation = if (offset == maxOffset) 4.dp else 0.dp
  ) {
    Column {
      Box(modifier = Modifier
        .height(imageHeight)
        .graphicsLayer {
          alpha = 1f - offsetProgress
        }) {

        AsyncImage(
          model = ImageRequest.Builder(LocalContext.current)
            .data(data = BuildConfig.BASE_BACKDROP_URL + movie.backdrop_path).build(),
          contentDescription = "Backdrop",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )

        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                colorStops = arrayOf(
                  Pair(0.4f, Transparent),
                  Pair(1f, MaterialTheme.colors.background)
                )
              )
            )
        )

        Row(
          modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp, vertical = 8.dp),
          verticalAlignment = Alignment.Bottom
        ) {
          Text(
            text = movie.tagline,
            style = MaterialTheme.typography.caption,
            fontStyle = FontStyle.Italic,
          )
        }
      }

      Column(
        Modifier
          .fillMaxWidth()
          .height(APP_BAR_COLLAPSED_HEIGHT),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = movie.title,
          fontSize = 26.sp,
          color = White,
          fontWeight = FontWeight.Bold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier
            .padding(horizontal = (14 + 28 * offsetProgress).dp)
            .scale(1f - 0.25f * offsetProgress)
        )
      }
    }
  }

  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxWidth()
      .statusBarsPadding()
      .height(APP_BAR_COLLAPSED_HEIGHT)
  ) {
    IconButton(onClick = { /*TODO*/ }) {
      Icon(
        painter = painterResource(id = R.drawable.ic_arrow_back),
        contentDescription = null
      )
    }
    Row {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          painter = painterResource(id = R.drawable.ic_heart_outline),
          contentDescription = null
        )
      }
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          painter = painterResource(id = R.drawable.ic_more_vertical),
          contentDescription = null
        )
      }
    }
  }
}

@Composable
fun MovieDetailContent(
  movie: MovieDetail,
  scrollState: LazyListState
) {
  LazyColumn(contentPadding = PaddingValues(top = APP_BAR_EXPANDED_HEIGHT), state = scrollState) {
    item {
      BasicInfo(movie = movie)
      OverviewSection(text = movie.overview)
    }
  }
}

@Composable
fun BasicInfo(
  movie: MovieDetail
) {
  val genres = movie.genres
  var text = ""
  for (g in genres) {
    text += if (g != genres.last()) "${g.name} • " else g.name
  }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
    ) {
      Text(
        text = text,
        color = DavyGrey,
        textAlign = TextAlign.Center
      )
    }
    Row(
      horizontalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
    ) {
      InfoColumn("2022", "Year")
      InfoColumn("2h22m", "Duration")
      InfoColumn("13+", "Age")
      InfoColumn("8.2", "Vote")
    }
  }
}

@Composable
fun InfoColumn(text: String, subText: String) {
  Column(
    modifier = Modifier
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = text, style = MaterialTheme.typography.h6)
      Spacer(modifier = Modifier.height(2.dp))
      Text(text = subText, style = MaterialTheme.typography.body2, color = DavyGrey)
    }
  }
}

@Composable
fun OverviewSection(text: String) {
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    Column(horizontalAlignment = Alignment.Start) {
      Text(text = "Overview", style = MaterialTheme.typography.h6,  color = White)
      Spacer(modifier = Modifier.height(6.dp))
      ExpandingText(text = text)
      // Text(text = text, color = White.copy(0.8f))
    }
  }
}
