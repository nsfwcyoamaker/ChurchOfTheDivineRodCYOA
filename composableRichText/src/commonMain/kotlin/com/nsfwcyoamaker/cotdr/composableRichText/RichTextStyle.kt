package com.nsfwcyoamaker.cotdr.composableRichText

import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle

data class RichTextStyle(
    val spanStyle: SpanStyle? = null,
    val paragraphStyle: ParagraphStyle? = null
)