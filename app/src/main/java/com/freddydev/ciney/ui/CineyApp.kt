package com.freddydev.ciney.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.components.CenterTopAppBar
import com.freddydev.ciney.ui.components.CineyBottomBar
import com.freddydev.ciney.ui.navigation.BottomNavItem
import com.freddydev.ciney.ui.navigation.CineyNavGraph
import com.freddydev.ciney.ui.navigation.MainScreens
import com.freddydev.ciney.ui.theme.ChineseBlack
import com.freddydev.ciney.ui.theme.CineyTheme
import com.freddydev.ciney.util.WindowSize
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CineyApp(windowSize: WindowSize) {
  CineyTheme {
    ProvideWindowInsets(
      consumeWindowInsets = false
    ) {
      val systemUiController = rememberSystemUiController()
      val navController = rememberNavController()
      SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
      }

      val tabs = remember {
        listOf(
          BottomNavItem.Home,
          BottomNavItem.Movie,
          BottomNavItem.TvShow,
          BottomNavItem.Discover,
          BottomNavItem.Profile
        )
      }

      Scaffold(
        bottomBar = { CineyBottomBar(navController = navController, tabs) }
      ) { innerPaddingModifier ->
        CineyNavGraph(
          navController = navController,
          windowSize = windowSize,
          modifier = Modifier.padding(innerPaddingModifier),
        )
      }
    }
  }
}
