package com.freddydev.ciney.util

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


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

  @RequiresApi(Build.VERSION_CODES.O)
  fun getCurrentDate(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM", Locale.getDefault())
    return current.format(formatter)
  }

  fun getLongDate(date: String): String {
    return formatDate(date, "EEEE, MMM d, yyyy")
  }
}