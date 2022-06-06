package com.freddydev.ciney.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CineyTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colors = CineyColors,
    typography = CineyTypography,
    shapes = CineyShapes,
    content = content
  )
}