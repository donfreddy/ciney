package com.freddydev.ciney.ui.screens.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.screens.profile.RoundImage
import com.freddydev.ciney.util.DateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppBAr(
  modifier: Modifier = Modifier
) {
  TopAppBar(
    modifier = modifier.padding(top = 10.dp),
    backgroundColor = Color.Transparent,
    elevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {
        Text(text = "Hello Freddy!", style = MaterialTheme.typography.h6, color = Color.White)
        Text(text = DateTime.getCurrentDate(), style = MaterialTheme.typography.caption)
      }
      RoundImage(
        image = painterResource(id = R.drawable.freddy),
        modifier = Modifier
          .size(45.dp)
          .fillMaxWidth(3f)
      )
    }
  }
}
