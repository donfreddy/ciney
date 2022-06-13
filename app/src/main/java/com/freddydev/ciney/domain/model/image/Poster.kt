package com.freddydev.ciney.domain.model.image

data class Poster(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val vote_average: Int,
    val vote_count: Int,
    val width: Int
)