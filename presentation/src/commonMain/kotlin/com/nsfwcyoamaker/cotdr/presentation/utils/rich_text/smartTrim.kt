package com.nsfwcyoamaker.cotdr.presentation.utils.rich_text

fun String.smartTrim(): String {
    return this.lines()
        .dropWhile { it.isBlank() }
        .dropLastWhile { it.isBlank() }
        .joinToString("\n")
        .trimIndent()
}