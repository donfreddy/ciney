package com.freddydev.ciney.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.freddydev.ciney.R

// Set fonts
val CineyFont = FontFamily(
  fonts = listOf(
    Font(R.font.sf_light, FontWeight.W300),
    // Font(R.font.sf_regular, FontWeight.W400),
    Font(R.font.sf_medium, FontWeight.W500),
    Font(R.font.sf_semibold, FontWeight.W600),
    // Font(R.font.sf_heavy),
    Font(R.font.sf_bold, FontWeight.W700)
  )
)

// Set of Material typography styles to start with
val CineyTypography = Typography(
  defaultFontFamily = CineyFont,
  h4 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 30.sp,
    lineHeight = 0.sp
  ),
  h5 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 0.sp
  ),
  h6 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 0.sp
  ),
  subtitle1 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    letterSpacing = 0.15.sp
  ),
  subtitle2 = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 0.1.sp
  ),
  body1 = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    letterSpacing = 0.5.sp
  ),
  body2 = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 0.25.sp
  ),
  button = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    letterSpacing = 1.25.sp
  ),
  caption = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    letterSpacing = 0.4.sp
  ),
  overline = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    letterSpacing = 1.sp
  )
)