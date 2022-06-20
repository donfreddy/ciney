package com.freddydev.ciney.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CineyTheme(isDarkTheme: Boolean = true, content: @Composable () -> Unit) {
  val cineyColors = if (isDarkTheme) CineyDarkTheme else CineyLightTheme

  MaterialTheme(
    colors = cineyColors,
    typography = CineyTypography,
    shapes = CineyShapes,
    content = content
  )
}