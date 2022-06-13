package com.freddydev.ciney.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.freddydev.ciney.R
import com.freddydev.ciney.ui.theme.DavyGrey

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextInputField(label: String, value: String, onValueChanged: (String) -> Unit) {
  val keyboardController = LocalSoftwareKeyboardController.current

  OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 10.dp, end = 10.dp),
    shape = RoundedCornerShape(corner = CornerSize(12.dp)),
    value = "Search for a movie, tv show...",
    onValueChange = {
      onValueChanged(it)
    },
    placeholder = {
      Text(
        text = "Search for a movie, tv show...",
        color = DavyGrey,
        maxLines = 1,
        style = MaterialTheme.typography.body1,
        overflow = TextOverflow.Clip
      )
    },
    enabled = false,
    maxLines = 1,
    leadingIcon = {
      Icon(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = null
      )
    },
    trailingIcon = {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          painter = painterResource(id = R.drawable.ic_options),
          contentDescription = null
        )
      }
    },
    label = { Text(text = label) },
    textStyle = MaterialTheme.typography.body1,
    colors = TextFieldDefaults.textFieldColors(
      unfocusedIndicatorColor = Color.Transparent,
      focusedIndicatorColor = Color.Transparent
    ),
    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
    keyboardActions = KeyboardActions(
      onSearch = {},
      onDone = {
        keyboardController?.hide()
      }
    )
  )
}