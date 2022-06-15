package com.freddydev.ciney.util

import com.freddydev.ciney.domain.model.orther.Genre

object Utils {

  fun getGenre(genres: List<Genre>): String {
    var text = ""
    for (g in genres) {
      text += if (g != genres.last()) "${g.name} • " else g.name
    }
    return text
  }

  fun getDuration(time: Int = 0): String {
    val hours = time / 60
    val minutes = time % 60
    return "${hours}h${minutes}min"
  }
}