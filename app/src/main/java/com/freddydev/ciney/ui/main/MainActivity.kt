package com.freddydev.ciney.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.freddydev.ciney.ui.navigation.CineyNavigation
import com.freddydev.ciney.ui.theme.CineyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // This app draws behind the system bars, so we want to handle fitting system windows
    WindowCompat.setDecorFitsSystemWindows(window, false)

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