package com.freddydev.ciney.ui.screens.movie_detail

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.freddydev.ciney.BuildConfig
import com.freddydev.ciney.R
import com.freddydev.ciney.domain.model.credit.Cast
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.video.Video
import com.freddydev.ciney.ui.common.Constants.APP_BAR_COLLAPSED_HEIGHT
import com.freddydev.ciney.ui.common.Constants.APP_BAR_EXPANDED_HEIGHT
import com.freddydev.ciney.ui.theme.DavyGrey
import com.freddydev.ciney.util.DateTime
import com.freddydev.ciney.util.ExpandingText
import com.freddydev.ciney.util.Utils
import com.freddydev.ciney.util.extensions.toYear
import com.freddydev.ciney.util.ratingbar.CustomRatingBar
import com.freddydev.ciney.util.ratingbar.RatingBarConfig
import com.freddydev.ciney.util.ratingbar.RatingBarStyle
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.skydoves.whatif.whatIfNotNullOrEmpty
import kotlin.math.max
import kotlin.math.min

@Composable
fun MovieDetailScreen(
  viewModel: MovieDetailViewModel = hiltViewModel()
) {
  val scrollState = rememberLazyListState()
  val movieState = viewModel.movieDetailState.value

  Box(modifier = Modifier.fillMaxSize()) {

    movieState.movie?.let { movie ->
      MovieDetailContent(movie = movie, scrollState = scrollState, viewModel = viewModel)
      ParallaxToolbar(movie = movie, scrollState = scrollState)
    }

    if (movieState.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
    }

    if (movieState.error.isNotBlank()) {
      Text(
        text = movieState.error,
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

        movie.tagline?.let { tagline ->
          Row(
            modifier = Modifier
              .fillMaxHeight()
              .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Bottom
          ) {
            Text(
              text = tagline,
              style = MaterialTheme.typography.caption,
              fontStyle = FontStyle.Italic,
            )
          }
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
          fontWeight = Bold,
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
  scrollState: LazyListState,
  viewModel: MovieDetailViewModel
) {
  val trailersState = viewModel.trailersState.value
//  val creditsState = viewModel.creditsState.value
//  val reviewsState = viewModel.reviewsState.value

  LazyColumn(contentPadding = PaddingValues(top = APP_BAR_EXPANDED_HEIGHT), state = scrollState) {
    item {
      MovieDetailSection(movie = movie)
      TrailersSection(trailersState = trailersState)
    }
  }
}

@Composable
fun MovieDetailSection(
  movie: MovieDetail
) {

  RatingBarView(rating = movie.vote_average)

  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // movie genres
    Row(
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
      Text(
        text = Utils.getGenre(genres = movie.genres),
        color = DavyGrey,
        textAlign = TextAlign.Center
      )
    }

    // Basic info
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.Start

      ) {
        InfoColumn(
          icon = R.drawable.ic_calendar_outline,
          text = DateTime.getShortDate(movie.release_date ?: "")
        )
        Spacer(modifier = Modifier.height(10.dp))
        InfoColumn(
          icon = R.drawable.ic_clock_outline,
          text = Utils.getDuration(time = movie.runtime ?: 0)
        )
      }
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Column(horizontalAlignment = Alignment.Start) {
          InfoColumn(icon = R.drawable.ic_monitor_outline, "13+")
          Spacer(modifier = Modifier.height(10.dp))
          InfoColumn(icon = R.drawable.ic_globe, text = movie.spoken_languages[0].name)
        }
      }
    }

//    RatingBarView()

    // Overview
    movie.overview?.let { overview ->
      Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          text = stringResource(id = R.string.overview),
          style = MaterialTheme.typography.h6,
          color = White
        )
        Spacer(modifier = Modifier.height(6.dp))
        ExpandingText(context = LocalContext.current, text = overview)
      }
    }
  }
}

@Composable
fun InfoColumn(@DrawableRes icon: Int, text: String) {
  Row(
    modifier = Modifier,
    // horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Icon(
      painter = painterResource(id = icon),
      contentDescription = null,
      // tint = MaterialTheme.colors.primary.copy(0.6f),
      modifier = Modifier.height(24.dp)
    )
    Spacer(modifier = Modifier.width(6.dp))
    Text(text = text)
  }
}

@Composable
fun TrailersSection(
  trailersState: MovieVideoState
) {

  trailersState.videos.whatIfNotNullOrEmpty { videos ->
    Column(horizontalAlignment = Alignment.Start) {
      Text(
        text = "${stringResource(id = R.string.trailers)}(${videos.size})",
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(horizontal = 16.dp),
        color = White,
      )
      Spacer(modifier = Modifier.height(10.dp))
      LazyRow(
        // modifier = Modifier.padding(horizontal = 16.dp)
      ) {
        items(items = videos) { video ->
          VideoThumbnail(video = video)
          Spacer(modifier = Modifier.height(10.dp))
        }
      }
    }
  }
}

@Composable
private fun VideoThumbnail(video: Video) {
  val context = LocalContext.current

  Surface(
    shape = RoundedCornerShape(8.dp),
    elevation = 8.dp,
    color = Red
  ) {
    ConstraintLayout(
      modifier = Modifier
        .width(170.dp)
        .height(120.dp)
        .clickable(
          onClick = {}
        )
    ) {

    }
  }
}

@Composable
fun CastSection() {
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    Column(horizontalAlignment = Alignment.Start) {
      Text(text = "Cast", style = MaterialTheme.typography.h6, color = White)
      Spacer(modifier = Modifier.height(6.dp))
      // CastList()
    }
  }
}

@Composable
fun CastList(
  casts: List<Cast>
) {
  LazyRow() {
    itemsIndexed(casts) { _, cast ->
      CastItem(cast = cast)
    }
  }
}

@Composable
fun CastItem(
  cast: Cast
) {
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    Column(horizontalAlignment = Alignment.Start) {
      Text(text = cast.name, style = MaterialTheme.typography.h6, color = White)
      Spacer(modifier = Modifier.height(2.dp))
      Text(text = cast.character, style = MaterialTheme.typography.body2, color = DavyGrey)
    }
  }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun RatingBarView(
  rating: Double
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 10.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    CustomRatingBar(
      value = (rating / 2).toFloat(),
      onValueChange = {},
      onRatingChanged = {},
      config = RatingBarConfig().size(20.dp).style(RatingBarStyle.HighLighted)
    )
    Spacer(modifier = Modifier.width(10.dp))
    Text(
      text = "$rating",
      style = MaterialTheme.typography.h6,
      color = DavyGrey,
      fontWeight = Bold
    )

  }
}