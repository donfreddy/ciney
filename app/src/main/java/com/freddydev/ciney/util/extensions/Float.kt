package com.freddydev.ciney.util.extensions

import com.freddydev.ciney.util.ratingbar.StepSize
import kotlin.math.roundToInt

fun Float.stepSized(stepSize: StepSize): Float {
  return if (stepSize is StepSize.ONE)
    this.roundToInt().toFloat()
  else {
    var value = this.toInt().toFloat()
    if (this < value.plus(0.5)) {
      if (this == 0f)
        return 0f
      value = value.plus(0.5).toFloat()
      value
    } else {
      this.roundToInt().toFloat()
    }
  }
}