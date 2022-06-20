package com.freddydev.ciney.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    CircularProgressIndicator(modifier = Modifier)
  }
}

@Composable
fun LoadingItem() {
  CircularProgressIndicator(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
      .wrapContentWidth(Alignment.CenterHorizontally)
  )
}

@Preview
@Composable
fun LoaderPreview() {
  LoadingView(modifier = Modifier.fillMaxSize())
}