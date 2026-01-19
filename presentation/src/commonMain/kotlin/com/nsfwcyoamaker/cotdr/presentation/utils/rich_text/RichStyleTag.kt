package com.nsfwcyoamaker.cotdr.presentation.utils.rich_text

import androidx.compose.ui.text.SpanStyle

fun interface RichStyleTag {
    fun resolve(attributes: Map<String, String>): SpanStyle?
}