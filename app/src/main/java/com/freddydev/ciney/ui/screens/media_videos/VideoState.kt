package com.freddydev.ciney.ui.screens.media_videos

import com.freddydev.ciney.domain.model.video.Video

data class VideoState(
  val isLoading: Boolean = false,
  val videos: List<Video> = emptyList(),
  val error: String = ""
)
