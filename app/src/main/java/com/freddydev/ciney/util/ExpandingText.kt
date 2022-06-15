package com.freddydev.ciney.util

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.freddydev.ciney.ui.theme.Begonia
import com.freddydev.ciney.ui.theme.CineyFont
import java.util.regex.Pattern

@Composable
fun ExpandingText(
  text: String,
  modifier: Modifier = Modifier,
  minimizedMaxLines: Int = 4,
  colorClickableText: Color = Begonia,
) {
  var isExpanded by remember { mutableStateOf(false) }
  val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
  var isClickable by remember { mutableStateOf(false) }
  val textLayoutResult = textLayoutResultState.value

  //we match the html tags and enable the links
  val textWithLinks = buildAnnotatedString {
    val htmlTagPattern = Pattern.compile(
      "(?i)<a([^>]+)>(.+?)</a>",
      Pattern.CASE_INSENSITIVE or Pattern.MULTILINE or Pattern.DOTALL
    )
    val matcher = htmlTagPattern.matcher(text)
    var matchStart: Int
    var matchEnd = 0
    var previousMatchStart = 0

    while (matcher.find()) {
      matchStart = matcher.start(1)
      matchEnd = matcher.end()
      val beforeMatch = text.substring(
        startIndex = previousMatchStart,
        endIndex = matchStart - 2
      )
      val tagMatch = text.substring(
        startIndex = text.indexOf(
          char = '>',
          startIndex = matchStart
        ) + 1,
        endIndex = text.indexOf(
          char = '<',
          startIndex = matchStart + 1
        )
      )
      append(
        beforeMatch
      )
      val annotation = text.substring(
        startIndex = matchStart + 7,
        endIndex = text.indexOf(
          char = '"',
          startIndex = matchStart + 7
        )
      )
      pushStringAnnotation(tag = "link_tag", annotation = annotation)
      withStyle(
        SpanStyle(
          color = MaterialTheme.colors.primary,
          textDecoration = TextDecoration.Underline
        )
      ) {
        append(tagMatch)
      }
      pop() //don't forget to add this line after a pushStringAnnotation
      previousMatchStart = matchEnd
    }

    //append the rest of the string
    if (text.length > matchEnd) {
      append(
        text.substring(
          startIndex = matchEnd,
          endIndex = text.length
        )
      )
    }
  }

  var textWithMoreLess by remember { mutableStateOf(textWithLinks) }
  LaunchedEffect(textLayoutResult) {
    if (textLayoutResult == null) return@LaunchedEffect

    when {
      isExpanded -> {
        textWithMoreLess = buildAnnotatedString {
          append(textWithLinks)
          pushStringAnnotation(tag = "show_more_tag", annotation = "")
          withStyle(SpanStyle(colorClickableText)) {
            append(" Show less")
          }
          pop()
        }
      }
      !isExpanded && textLayoutResult.hasVisualOverflow -> { //return true if either vertical overflow or horizontal overflow happens.
        val lastCharIndex = textLayoutResult.getLineEnd(3 - 1)
        val showMoreString = "... Show More"
        val adjustedText = textWithLinks
          .substring(startIndex = 0, endIndex = lastCharIndex)
          .dropLast(showMoreString.length)
          .dropLastWhile { it == ' ' || it == '.' }

        textWithMoreLess = buildAnnotatedString {
          append(adjustedText)
          pushStringAnnotation(tag = "show_more_tag", annotation = "")
          withStyle(SpanStyle(colorClickableText)) {
            append(showMoreString)
          }
          pop()
        }
        isClickable = true
      }
    }
  }

  val uriHandler = LocalUriHandler.current

  SelectionContainer {
    ClickableText(
      text = textWithMoreLess,
      style = TextStyle(
        color = MaterialTheme.colors.onBackground.copy(0.8f),
        fontSize = 15.sp,
        fontFamily = CineyFont
      ),
      onClick = { offset ->
        textWithMoreLess.getStringAnnotations(
          tag = "link_tag",
          start = offset,
          end = offset
        ).firstOrNull()?.let { stringAnnotation ->
          uriHandler.openUri(stringAnnotation.item)
        }
        if (isClickable) {
          textWithMoreLess.getStringAnnotations(
            tag = "show_more_tag",
            start = offset,
            end = offset
          ).firstOrNull()?.let {
            isExpanded = !isExpanded
          }
        }
      },
      maxLines = if (isExpanded) Int.MAX_VALUE else minimizedMaxLines,
      onTextLayout = { textLayoutResultState.value = it },
      modifier = modifier
        .animateContentSize()
    )
  }
}
