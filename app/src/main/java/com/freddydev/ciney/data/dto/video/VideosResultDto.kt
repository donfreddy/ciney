package com.freddydev.ciney.data.dto.video

import com.freddydev.ciney.domain.model.video.VideosResult

data class VideosResultDto(
  val id: Int,
  val videos: List<VideoDto>?
)

fun VideosResultDto.toVideosResult() = VideosResult(
  videos?.map { it.toVideo() }
)