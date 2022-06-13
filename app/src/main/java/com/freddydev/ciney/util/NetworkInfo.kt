package com.freddydev.ciney.util

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import timber.log.Timber
import java.lang.Exception

object NetworkInfo {

  fun isConnected(context: Context): Boolean {
    return try {
      val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      val nInfo = cm.activeNetworkInfo
      nInfo != null && nInfo.isAvailable && nInfo.isConnected;
    } catch (e: Exception) {
      Timber.tag(e.message.toString());
      false
    }
  }
}