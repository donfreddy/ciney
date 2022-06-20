package com.freddydev.ciney.util

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.freddydev.ciney.BuildConfig
import com.freddydev.ciney.domain.model.orther.Genre
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {

  @JvmStatic
  fun getPosterPath(posterPath: String): String {
    return BuildConfig.BASE_POSTER_URL + posterPath
  }

  @JvmStatic
  fun getBackdropPath(backdropPath: String): String {
    return BuildConfig.BASE_BACKDROP_URL + backdropPath
  }

  @JvmStatic
  fun getYoutubeVideoPath(videoPath: String): String {
    return BuildConfig.YT_BASE_URL + videoPath
  }

  @JvmStatic
  fun getYoutubeThumbnailPath(thumbnailPath: String): String {
    return "${BuildConfig.YT_THUMBNAIL_URL}$thumbnailPath/default.jpg"
  }

  fun getGenre(genres: List<Genre>): String {
    var text = ""
    for (g in genres) {
      text += if (g != genres.last()) "${g.name} • " else g.name
    }
    return text
  }

  fun getDuration(time: Int): String {
    val hours = time / 60
    val minutes = time % 60
    return "${hours}h${minutes}min"
  }

  fun calculateStars(
    draggedWidth: Float,
    width: Float,
    numStars: Int,
    padding: Int
  ): Float {
    var overAllComposeWidth = width
    val spacerWidth = numStars * (2 * padding)
    overAllComposeWidth -= spacerWidth
    return if (draggedWidth != 0f) ((draggedWidth / overAllComposeWidth) * numStars) else 0f
  }

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

  fun formatDate(date: String, format: String): String {
    lateinit var result: String
    val old = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    try {
      val oldDate = old.parse(date)!!
      val newFormat = SimpleDateFormat(format, Locale.getDefault())
      result = newFormat.format(oldDate)
    } catch (e: ParseException) {
      e.printStackTrace()
    }
    return result
  }

  @RequiresApi(Build.VERSION_CODES.O)
  fun getCurrentDate(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM", Locale.getDefault())
    return current.format(formatter)
  }
}