package com.freddydev.ciney.util

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

object DateTime {

  @SuppressLint("SimpleDateFormat")
  private fun formatDate(date: String, format: String): String {
    lateinit var result: String
    val old = SimpleDateFormat("yyyy-MM-dd")

    try {
      val oldDate = old.parse(date)!!
      val newFormat = SimpleDateFormat(format)
      result = newFormat.format(oldDate)
    } catch (e: ParseException) {
      e.printStackTrace()
    }
    return result
  }

  fun getShortDate(date: String): String {
    return formatDate(date, "dd MMMM yyyy")
  }

  fun getLongDate(date: String): String {
    return formatDate(date, "EEEE, MMM d, yyyy")
  }
}