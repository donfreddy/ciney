package com.freddydev.ciney.util.ratingbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.freddydev.ciney.ui.theme.PrimaryColor
import com.freddydev.ciney.ui.theme.SecondaryColor

class RatingBarConfig {
  var size: Dp = 40.dp
    private set
  var padding: Dp = 2.dp
    private set
  var style: RatingBarStyle = RatingBarStyle.Normal
    private set
  var numStars: Int = 5
    private set
  var isIndicator: Boolean = true
    private set
  var activeColor: Color = SecondaryColor
    private set
  var inactiveColor: Color = PrimaryColor.copy(alpha = 0.5f)
    private set
  var stepSize: StepSize = StepSize.ONE
    private set
  var hideInactiveStars: Boolean = false
    private set

  fun size(value: Dp): RatingBarConfig = apply { size = value }

  fun style(value: RatingBarStyle): RatingBarConfig = apply { style = value }
}
