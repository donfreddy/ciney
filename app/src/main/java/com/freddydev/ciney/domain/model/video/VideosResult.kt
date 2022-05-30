package com.freddydev.ciney.domain.model.video

import com.freddydev.ciney.domain.model.video.Video

data class VideosResult(
  val id: Int,
  val videos: List<Video>
)