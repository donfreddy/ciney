package com.freddydev.ciney.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val DarkTangerine = Color(0xFFFCA311)
val SunsetOrange = Color(0xFFFB5558)

// Ciney colors
val BackgroundColor = Color(0xFF000000)
val PrimaryColor = Color(0xFFFA7777)
val SecondaryColor = Color(0xFFFFC145)

val White87 = Color.White.copy(0.87f)
val White60 = Color.White.copy(0.6f)
val White38 = Color.White.copy(0.38f)

val CineyLightTheme = lightColors()

val CineyDarkTheme = darkColors(
  primary = PrimaryColor,
  secondary = SecondaryColor,
  surface = BackgroundColor,
  background = BackgroundColor,
  onBackground = White87,
  onSurface = White87,

  /* Other default colors to override
     background = Color.White,
     surface = Color.White,
     onPrimary = Color.White,
     onSecondary = Color.Black,
     onBackground = Color.Black,
     onSurface = Color.Black,
   */
)