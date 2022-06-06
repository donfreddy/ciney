package com.freddydev.ciney.util.extensions

import com.freddydev.ciney.BuildConfig
import java.util.*

fun String.toPosterPath() = BuildConfig.BASE_POSTER_URL + this

fun String.toBackdropPath() = BuildConfig.BASE_BACKDROP_URL + this

fun String.toCapitalCase() = this.substring(0, 1).uppercase(Locale.ROOT) + this.substring(1)

