package com.freddydev.ciney.ui.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MovieScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      text = "Movie Screen",
      modifier = Modifier.align(Alignment.CenterHorizontally),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h6

    )
  }
}