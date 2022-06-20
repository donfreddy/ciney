package com.freddydev.ciney.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CineyScrollableTabRow(
  modifier: Modifier = Modifier,
  tabs: List<String>,
  selectedTabIndex: Int,
  onTabClick: (Int) -> Unit
) {
  val density = LocalDensity.current

  val tabWidths = remember {
    val tabWidthStateList = mutableStateListOf<Dp>()
    repeat(tabs.size) {
      tabWidthStateList.add(0.dp)
    }
    tabWidthStateList
  }

  ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    backgroundColor = MaterialTheme.colors.background,
    contentColor = Color.White,
    edgePadding = 0.dp,
    divider = {
      TabRowDefaults.Divider(
        color = Color.Transparent
      )
    },
    indicator = { tabPositions ->
      TabRowDefaults.Indicator(
        color = MaterialTheme.colors.primary,
        height = 4.dp,
        modifier = modifier
          .cineyTabIndicatorOffset(
            currentTabPosition = tabPositions[selectedTabIndex],
            tabWidth = tabWidths[selectedTabIndex]
          )
          .then(
            other = Modifier.clip(
              shape = RoundedCornerShape(corner = CornerSize(4.dp))
            )
          )
      )
    }
  ) {
    tabs.forEachIndexed { tabIndex, tab ->
      Tab(
        selected = tabIndex == tabIndex,
        // unselectedContentColor = DavyGrey,
        onClick = { onTabClick(tabIndex) },
        text = {
          Text(
            text = tab,
            onTextLayout = { textLayoutResult ->
              tabWidths[tabIndex] = with(density) { textLayoutResult.size.width.toDp() }
            },
            style = MaterialTheme.typography.h6
          )
        },
      )
    }
  }
}

fun Modifier.cineyTabIndicatorOffset(
  currentTabPosition: TabPosition,
  tabWidth: Dp
): Modifier = composed(
  inspectorInfo = debugInspectorInfo {
    name = "cineyTabIndicatorOffset"
    value = currentTabPosition
  }
) {
  val currentTabWidth by animateDpAsState(
    targetValue = tabWidth,
    animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
  )
  val indicatorOffset by animateDpAsState(
    targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
    animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
  )
  fillMaxWidth()
    .wrapContentSize(Alignment.BottomStart)
    .offset(x = indicatorOffset)
    .width(currentTabWidth)
}
