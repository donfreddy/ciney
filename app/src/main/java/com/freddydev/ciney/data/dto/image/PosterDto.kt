package com.freddydev.ciney.data.dto.image

data class PosterDto(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val iso_639_1: String,
    val vote_average: Int,
    val vote_count: Int,
    val width: Int
)