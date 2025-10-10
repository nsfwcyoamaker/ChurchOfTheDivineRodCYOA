package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.withStyle

/**
 * A Text composable that allows adjusting the space between words.
 *
 * @param text The text to display.
 * @param wordSpacingFactor A multiplier for the width of the space character.
 * 0.5f makes word spacing 50% narrower.
 * 1.0f is the default.
 * 1.5f makes word spacing 50% wider.
 */
@Composable
fun CustomWordSpacingText(
    text: String,
    wordSpacingFactor: Float = 1.0f,
    style: TextStyle = TextStyle.Default
) {
    // buildAnnotatedString allows us to apply different styles to different parts of the text.
    val annotatedString = buildAnnotatedString {
        text.forEach { char ->
            if (char.isWhitespace()) {
                // Apply a special style ONLY to the space characters
                withStyle(
                    style = SpanStyle(
                        // TextGeometricTransform allows scaling, skewing, etc.
                        // We scale the horizontal axis (X) to change the width.
                        textGeometricTransform = TextGeometricTransform(scaleX = wordSpacingFactor)
                    )
                ) {
                    append(char)
                }
            } else {
                // Append all other characters normally
                append(char)
            }
        }
    }

    Text(
        text = annotatedString,
        style = style
    )
}