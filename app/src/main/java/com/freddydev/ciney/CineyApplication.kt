package com.freddydev.ciney

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CineyApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    // Add Timber to the debug build only.
    Timber.plant(Timber.DebugTree())
  }
}