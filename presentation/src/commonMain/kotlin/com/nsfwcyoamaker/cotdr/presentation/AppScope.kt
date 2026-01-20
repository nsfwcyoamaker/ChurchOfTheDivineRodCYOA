package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.nsfwcyoamaker.cotdr.composableRichText.LocalRichTextStyles
import com.nsfwcyoamaker.cotdr.presentation.theme.defaultTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.makeRichTextStylesMap

@Composable
fun AppScope(
    content: @Composable () -> Unit,
) {
    MaterialTheme {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.merge(defaultTextStyle),
            LocalRichTextStyles provides makeRichTextStylesMap(),
        ) {
            content()
        }
    }
}