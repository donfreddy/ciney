package com.freddydev.ciney.ui.screens.media_videos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.freddydev.ciney.util.Utils

@OptIn(ExperimentalCoilApi::class)
@Composable
fun VideoThumbnail(thumbnailPath: String, modifier: Modifier = Modifier) {
  Image(
    painter = rememberAsyncImagePainter(
      ImageRequest.Builder(LocalContext.current)
        .data(data = Utils.getYoutubeThumbnailPath(thumbnailPath))
        .apply(block = fun ImageRequest.Builder.() {
          crossfade(true)
          // size(512, 512)
        }).build()
    ),
    contentDescription = "Thumbnail",
    modifier = modifier.fillMaxWidth(),
    contentScale = ContentScale.Crop
  )
}
