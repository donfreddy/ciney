package com.freddydev.ciney.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.freddydev.ciney.navigation.BottomNavGraph
import com.freddydev.ciney.ui.components.BottomNavBar

@Composable
fun MainScreen() {
  val navController = rememberNavController()
  Scaffold(
    bottomBar = { BottomNavBar(navController = navController) }
  ) {

    BottomNavGraph(navController = navController)
  }
}