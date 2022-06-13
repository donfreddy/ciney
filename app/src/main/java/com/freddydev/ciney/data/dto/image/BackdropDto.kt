package com.freddydev.ciney.domain.model.image

data class BackdropDto(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val iso_639_1: Any,
    val vote_average: Int,
    val vote_count: Int,
    val width: Int
)