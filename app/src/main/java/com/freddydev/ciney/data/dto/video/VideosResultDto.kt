package com.freddydev.ciney.data.dto.video

import com.freddydev.ciney.domain.model.video.VideosResult

data class VideosResultDto(
  val id: Int,
  val results: List<VideoDto>
)

fun VideosResultDto.toVideosResult() = VideosResult(
  videos = results.map { it.toVideo() }
)