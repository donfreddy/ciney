package com.freddydev.ciney.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import com.freddydev.ciney.ui.CineyApp
import com.freddydev.ciney.util.rememberWindowSizeClass
import dagger.hilt.android.AndroidEntryPoint


/**
 * @author Don Freddy
 * @date Jun 03, 2022 6:15:00 AM
 * @description [MainActivity] is the entry point of the app.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @RequiresApi(Build.VERSION_CODES.O)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // This app draws behind the system bars, so we want to handle fitting system windows
    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      val windowSizeClass = rememberWindowSizeClass()
      CineyApp(windowSize = windowSizeClass)
    }
  }
}
