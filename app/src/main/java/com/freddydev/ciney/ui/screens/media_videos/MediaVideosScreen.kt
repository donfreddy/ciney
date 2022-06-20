package com.freddydev.ciney.ui.screens.media_videos

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.freddydev.ciney.R
import com.freddydev.ciney.domain.model.video.Video
import com.freddydev.ciney.ui.components.LoadingView
import com.freddydev.ciney.ui.screens.media_videos.components.VideoThumbnail
import com.freddydev.ciney.ui.theme.White38
import com.freddydev.ciney.ui.theme.White87
import com.freddydev.ciney.util.Utils
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.MimeTypes
import com.skydoves.whatif.whatIfNotNullOrEmpty

@Composable
fun MediaVideosScreen(
  navigateBack: () -> Unit,
  viewModel: MediaVideoViewModel = hiltViewModel(),
) {
  val trailersState = viewModel.trailersState.value

  if (trailersState.isLoading) {
    LoadingView(modifier = Modifier.fillMaxSize())
  }

  if (trailersState.error.isNotBlank()) {
    // Todo: Handle error messages
    navigateBack.invoke()
    return
  }

  trailersState.videos.whatIfNotNullOrEmpty { videos ->
    ShowMediaVideos(videos = videos)
  }
}

@Composable
fun ShowMediaVideos(videos: List<Video>) {
  val playingIndex = remember { mutableStateOf(0) }
  fun onTrailerChange(index: Int) {
    playingIndex.value = index
  }

  Column {
    VideoPlayer(
      modifier = Modifier.weight(1f, fill = true),
      videos = videos,
      playingIndex = playingIndex,
      onTrailerChange = { newIndex -> onTrailerChange(newIndex) }
    )
    LazyColumn(
      modifier = Modifier.weight(1f, fill = true)
    ) {
      itemsIndexed(videos) { index: Int, item: Video ->
        ShowTrailers(
          index = index,
          trailer = item,
          playingIndex = playingIndex,
          onTrailerClicked = { newIndex -> onTrailerChange(newIndex) })
      }
    }
  }
}

@Composable
fun ShowTrailers(
  index: Int,
  trailer: Video,
  playingIndex: State<Int>,
  onTrailerClicked: (Int) -> Unit
) {
  val currentlyPlaying = remember { mutableStateOf(false) }
  currentlyPlaying.value = index == playingIndex.value

  ConstraintLayout(
    modifier = Modifier
      .padding(horizontal = 8.dp)
      .wrapContentSize()
      .clickable {
        onTrailerClicked(index)
      }
  ) {
    val (thumbnail, play, title, nowPlaying, divider) = createRefs()

    VideoThumbnail(
      thumbnailPath = trailer.key,
      modifier = Modifier
        .height(120.dp)
        .width(120.dp)
        .clip(RoundedCornerShape(20.dp))
        .shadow(elevation = 20.dp)
        .constrainAs(thumbnail) {
          top.linkTo(parent.top, margin = 8.dp)
          start.linkTo(parent.start, margin = 8.dp)
          bottom.linkTo(parent.bottom)
        }
    )
    if (currentlyPlaying.value) {
      Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.ic_play_arrow),
        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
        contentDescription = null,
        modifier = Modifier
          .height(30.dp)
          .width(30.dp)
          .graphicsLayer {
            clip = true
            shadowElevation = 20.dp.toPx()
          }
          .constrainAs(play) {
            top.linkTo(thumbnail.top)
            start.linkTo(thumbnail.start)
            end.linkTo(thumbnail.end)
            bottom.linkTo(thumbnail.bottom)
          },
      )
    }
    Text(
      text = trailer.name,
      modifier = Modifier
        .constrainAs(title) {
          top.linkTo(thumbnail.top, margin = 8.dp)
          start.linkTo(thumbnail.end, margin = 8.dp)
          end.linkTo(parent.end, margin = 8.dp)
          width = Dimension.preferredWrapContent
          height = Dimension.wrapContent
        },
      color = White87,
      fontSize = 10.sp,
      textAlign = TextAlign.Center,
      maxLines = 2,
      // softWrap = true,
      style = typography.h5
    )
    if (currentlyPlaying.value) {
      Text(
        text = "Now Playing",
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
        style = typography.h6,
        modifier = Modifier.constrainAs(nowPlaying) {
          top.linkTo(title.bottom, margin = 8.dp)
          start.linkTo(thumbnail.end, margin = 8.dp)
          bottom.linkTo(thumbnail.bottom, margin = 8.dp)
          end.linkTo(parent.end, margin = 8.dp)
          width = Dimension.preferredWrapContent
          height = Dimension.preferredWrapContent
        }
      )
    }
    Divider(
      modifier = Modifier
        .padding(horizontal = 2.dp)
        .constrainAs(divider) {
          top.linkTo(title.bottom)
        },
      color = White38
    )
  }
}

@Composable
fun VideoPlayer(
  videos: List<Video>,
  playingIndex: State<Int>,
  onTrailerChange: (Int) -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val lifecycleOwner = LocalLifecycleOwner.current
  val visible = remember { mutableStateOf(true) }
  val videoTitle = remember { mutableStateOf(videos[playingIndex.value].name) }
  val mediaItems = arrayListOf<MediaItem>()

  videos.forEach { video ->
    val mediaItem = MediaItem.Builder()
      .setMediaId(video.id)
      .setUri(Utils.getYoutubeVideoPath(video.key))
      .setTag(video)
      .setMimeType(MimeTypes.APPLICATION_MPD)
      .setMediaMetadata(MediaMetadata.Builder().setDisplayTitle(video.name).build())
      .build()

    mediaItems.add(mediaItem)
  }

  val exoPlayer = remember(context) {
    SimpleExoPlayer.Builder(context).build().apply {
      this.setMediaItems(mediaItems)
      this.prepare()
      this.addListener(
        object : Player.Listener {
          override fun onEvents(player: Player, events: Player.Events) {
            super.onEvents(player, events)
            if (player.contentPosition >= 200) visible.value = false
          }

          override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
            super.onMediaItemTransition(mediaItem, reason)
            onTrailerChange(this@apply.currentPeriodIndex)
            visible.value = true
            videoTitle.value = mediaItem?.mediaMetadata?.displayTitle.toString()
          }
        },
      )
    }
  }

  exoPlayer.seekTo(playingIndex.value, C.TIME_UNSET)
  exoPlayer.playWhenReady = true

  ConstraintLayout(modifier = modifier.background(Red)) {
    val (title, videoPlayer) = createRefs()

    AnimatedVisibility(
      visible = visible.value,
      enter = fadeIn(initialAlpha = 0.4f),
      exit = fadeOut(animationSpec = tween(durationMillis = 250)),
      modifier = Modifier.constrainAs(title) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
      }
    ) {
      Text(
        text = videoTitle.value,
        style = typography.h6,
        color = White,
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
          .wrapContentHeight()
      )
    }

    DisposableEffect(
      AndroidView(
        modifier = modifier
          .constrainAs(videoPlayer) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
          },
        factory = {
          // StyledPlayerView
          PlayerView(context).apply {
            player = exoPlayer
            layoutParams = FrameLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT,
              ViewGroup.LayoutParams.MATCH_PARENT
            )
            // showController()
          }
        }), lifecycleOwner
    ) {

      val observer = LifecycleEventObserver { _, event ->
        when (event) {
          Lifecycle.Event.ON_START -> {
            if (exoPlayer.isPlaying.not()) exoPlayer.play()
          }
          Lifecycle.Event.ON_STOP -> exoPlayer.pause()
          else -> Unit
        }
      }

      lifecycleOwner.lifecycle.addObserver(observer)

      onDispose {
        lifecycleOwner.lifecycle.removeObserver(observer)
        exoPlayer.release()
      }
    }
  }
}

