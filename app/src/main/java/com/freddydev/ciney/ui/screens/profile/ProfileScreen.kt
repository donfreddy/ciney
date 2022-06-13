package com.freddydev.ciney.ui.screens.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.theme.DavyGrey
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun ProfileScreen(
  modifier: Modifier = Modifier,
) {
  val scrollState = rememberScrollState()

  Column(
    modifier = modifier
      .verticalScroll(scrollState)
      .statusBarsPadding()
  ) {
    ProfileSection()
    Spacer(modifier = Modifier.height(20.dp))
    EditProfileButton(modifier = Modifier, onClick = {})
    Spacer(modifier = Modifier.height(20.dp))
    ProfileRowSection()
    Spacer(Modifier.navigationBarsHeight(additional = 56.dp))
  }
}

@Composable
fun ProfileSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    RoundImage(
      image = painterResource(id = R.drawable.freddy),
      modifier = Modifier
        .size(130.dp)
        .fillMaxWidth(3f)
    )
    Spacer(modifier = Modifier.height(16.dp))
    ProfileDescription(
      displayName = "Don Freddy",
      description = "Love movies to the moon and back."
    )
    Spacer(modifier = Modifier.height(20.dp))
    StatSection(modifier = Modifier)
  }
}

@Composable
fun RoundImage(
  image: Painter,
  modifier: Modifier = Modifier
) {
  Image(
    painter = image,
    contentDescription = null,
    modifier = modifier
      .aspectRatio(1f, matchHeightConstraintsFirst = true)
      .border(
        width = 2.dp,
        color = MaterialTheme.colors.primary,
        shape = CircleShape
      )
      .padding(0.dp)
      .clip(CircleShape)
  )
}

@Composable
fun EditProfileButton(
  onClick: () -> Unit,
  modifier: Modifier
) {
  Button(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp),
    onClick = onClick
  ) {
    Row(
      modifier = Modifier.padding(vertical = 4.dp),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    )
    {
      Icon(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = null
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(text = "Edit profile", style = MaterialTheme.typography.button)
    }
  }
}

@Composable
fun ProfileDescription(
  displayName: String,
  description: String,
) {
  Column(
    modifier = Modifier.padding(top = 2.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = displayName,
      style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
    )
    Text(
      text = description,
      style = MaterialTheme.typography.body1,
      color = DavyGrey
    )
  }
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 30.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    ProfileStat(numberText = "23", text = "Reviews")
    ProfileStat(numberText = "16", text = "Edits")
    ProfileStat(numberText = "134", text = "Rates")
  }
}

@Composable
fun ProfileStat(
  numberText: String,
  text: String,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = text, color = DavyGrey)
  }
}

@Composable
fun ProfileRowSection(modifier: Modifier = Modifier) {
  Column()
  {
    ProfileRow(title = "Favorites", icon = R.drawable.ic_heart, onTap = {})
    ProfileRow(title = "Ratings", icon = R.drawable.ic_star, onTap = {})
    ProfileRow(title = "lists", icon = R.drawable.ic_list, onTap = {})
    ProfileRow(title = "Watchlist", icon = R.drawable.ic_bookmark, onTap = {})
    ProfileRow(title = "Settings", icon = R.drawable.ic_settings, onTap = {})
  }
}

@Composable
fun ProfileRow(
  modifier: Modifier = Modifier,
  title: String,
  @DrawableRes icon: Int,
  onTap: () -> Unit
) {
  Row(
    modifier = modifier
      .height(60.dp)
      .fillMaxWidth()
      .clickable { },
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row() {
      Icon(
        painter = painterResource(id = icon),
        tint = DavyGrey,
        contentDescription = null,
        modifier = Modifier.padding(start = 10.dp)
      )
      Spacer(modifier = Modifier.width(12.dp))
      Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
      )
    }

    Icon(
      painter = painterResource(id = R.drawable.ic_arrow_ios_forward),
      tint = DavyGrey,
      contentDescription = null,
      modifier = Modifier.padding(end = 12.dp)
    )
  }
  CineyDivider()
}

@Composable
fun CineyDivider(modifier: Modifier = Modifier) {
  Divider(
    color = DavyGrey.copy(alpha = 0.1f),
    thickness = 1.dp,
    modifier = modifier.padding(horizontal = 12.dp)
  )
}