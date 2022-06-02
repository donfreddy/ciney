package com.freddydev.ciney.ui.movie

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freddydev.ciney.R

@Composable
fun MovieScreen() {// viewModel: MovieViewModel = hiltViewModel()
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    color = colorResource(id = R.color.blue),
    contentColor = MaterialTheme.colors.onBackground
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ) {
      Text(
        text = "Movie Screen",
        modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.h6
      )
    }
  }
}