package com.freddydev.ciney.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RowTitle(
  title: String,
  onViewMore: () -> Unit = {}
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 10.dp, vertical = 14.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom
  ) {
    Text(text = title, style = MaterialTheme.typography.h6)
    Text(
      text = "See All",
      color = MaterialTheme.colors.primary,
      modifier = Modifier
        .clickable { onViewMore() }
        .padding(vertical = 4.dp),
      fontWeight = FontWeight.W300,
      fontSize = 14.sp
    )
  }
}