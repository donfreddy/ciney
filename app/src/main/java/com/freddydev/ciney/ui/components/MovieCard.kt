package com.freddydev.ciney.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
  Column(
    modifier = modifier.clickable { selectPoster(movie.id) }
  ) {

    AsyncImage(
      model = ImageRequest.Builder(LocalContext.current)
        .data(data = BASE_POSTER_URL + movie.poster_path).build(),
      contentDescription = "Poster",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .aspectRatio(2 / 3f)
        .clip(RoundedCornerShape(corner = CornerSize((16.dp))))
    )
  }
}