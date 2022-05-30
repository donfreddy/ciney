package com.freddydev.ciney.util

import java.util.*

object Localization {
  val country: String
    get() {
      var country = Locale.getDefault().country.lowercase(Locale.getDefault())

      when (country) {
        "id" -> {}
        else -> country = "en"
      }
      return country
    }
}