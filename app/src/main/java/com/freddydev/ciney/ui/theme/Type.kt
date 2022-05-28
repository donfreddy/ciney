package com.freddydev.ciney.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.freddydev.ciney.R

// Set fonts
val Nunito = FontFamily(
  fonts = listOf(
    Font(R.font.nunito_light, FontWeight.W300),
    Font(R.font.nunito_regular, FontWeight.W400),
    Font(R.font.nunito_medium, FontWeight.W500),
    Font(R.font.nunito_semibold, FontWeight.W600),
    Font(R.font.nunito_bold, FontWeight.W700)
  )
)

// Set of Material typography styles to start with
val CineyTypography = Typography(

  h1 = TextStyle(
    fontFamily = Nunito,
    fontSize = 96.sp,
    fontWeight = FontWeight.Light,
    lineHeight = 117.sp,
    letterSpacing = (-1.5).sp
  ),
  h2 = TextStyle(
    fontFamily = Nunito,
    fontSize = 60.sp,
    fontWeight = FontWeight.Light,
    lineHeight = 73.sp,
    letterSpacing = (-0.5).sp
  ),
  h3 = TextStyle(
    fontFamily = Nunito,
    fontSize = 48.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 59.sp
  ),
  h4 = TextStyle(
    fontFamily = Nunito,
    fontSize = 30.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 37.sp
  ),
  h5 = TextStyle(
    fontFamily = Nunito,
    fontSize = 24.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 29.sp
  ),
  h6 = TextStyle(
    fontFamily = Nunito,
    fontSize = 20.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 24.sp
  ),
  subtitle1 = TextStyle(
    fontFamily = Nunito,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
  ),
  subtitle2 = TextStyle(
    fontFamily = Nunito,
    fontSize = 14.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 17.sp,
    letterSpacing = 0.1.sp
  ),
  body1 = TextStyle(
    fontFamily = Nunito,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 20.sp,
    letterSpacing = 0.15.sp
  ),
  body2 = TextStyle(
    fontFamily = Nunito,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp
  ),
  button = TextStyle(
    fontFamily = Nunito,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 1.25.sp
  ),
  caption = TextStyle(
    fontFamily = Nunito,
    fontSize = 12.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 0.sp
  ),
  overline = TextStyle(
    fontFamily = Nunito,
    fontSize = 12.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 1.sp
  )
)