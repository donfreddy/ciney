package com.freddydev.ciney.ui.screens.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.freddydev.ciney.BuildConfig.BASE_POSTER_URL
import com.freddydev.ciney.domain.model.movie.Movie

@Composable
fun MovieCard(
  movie: Movie,
  modifier: Modifier = Modifier,
  selectPoster: (Int) -> Unit,
) {
  Box(
    modifier = modifier
      .padding(horizontal = 4.dp)
  ) {

    AsyncImage(
      model = ImageRequest.Builder(LocalContext.current)
        .data(data = BASE_POSTER_URL + movie.poster_path).build(),
      contentDescription = "Poster",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .aspectRatio(2 / 3f, matchHeightConstraintsFirst = true)
        .clip(
          RoundedCornerShape(corner = CornerSize((10.dp)))
        )
        .clickable { selectPoster(movie.id) }
    )
  }
}