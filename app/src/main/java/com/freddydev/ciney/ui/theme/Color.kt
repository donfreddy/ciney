package com.freddydev.ciney.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

val YankeesBlue = Color(0xFF14213D)
val DarkTangerine = Color(0xFFFCA311)

// Ciney colors
val ChineseBlack = Color(0xFF111112)
val EerieBlack = Color(0xFF1C1C1E)
val CharlestonGreen = Color(0xFF27272A)
val DavyGrey = Color(0xFF5A5A5E)
val Begonia = Color(0xFFFA7777)
val CyanBlue = Color(0xFF507ECC)

private val colorRange = 0..256

fun Color.Companion.randomColor() =
  Color(colorRange.random(), colorRange.random(), colorRange.random())

@Composable
fun Color.Companion.rateColors(movieRate: Double): List<Color> = remember(movieRate) {
  when {
    movieRate <= 4.5 -> listOf(Color(0xffe32d20), Color(0xff9c180e))
    movieRate < 7 -> listOf(Color(0xffe36922), Color(0xff963d09))
    movieRate < 8.5 -> listOf(Color(0xff87bf32), Color(0xff578216))
    else -> listOf(Color(0xff34c937), Color(0xff0d750f))
  }
}

val CineyColors = darkColors(

  primary = Begonia,
  onPrimary = Color.Black,
  primaryVariant = Begonia,
  secondary = CyanBlue,
  onSecondary = Color.Black,
  error = Begonia,
  onError = Color.Black,
  background = ChineseBlack

  /* Other default colors to override
     background = Color.White,
     surface = Color.White,
     onPrimary = Color.White,
     onSecondary = Color.Black,
     onBackground = Color.Black,
     onSurface = Color.Black,
   */
)


