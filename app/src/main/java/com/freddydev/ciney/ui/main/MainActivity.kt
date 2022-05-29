package com.freddydev.ciney.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.freddydev.ciney.navigation.CineyNavigation
import com.freddydev.ciney.ui.theme.CineyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CineyTheme {
        CineyNavigation()
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  CineyTheme {
    CineyNavigation()
  }
}