package com.freddydev.ciney.navigation


sealed class CineyScreens(val route: String) {
  object Home : CineyScreens("home")
  object Search : CineyScreens("search")

  fun withArgs(vararg args: String): String {
    return buildString {
      append(route)
      args.forEach { arg ->
        append("/$arg")
      }
    }
  }
}
