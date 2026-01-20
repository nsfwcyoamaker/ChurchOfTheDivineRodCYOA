package com.nsfwcyoamaker.cotdr.composableRichText

fun String.smartTrim(): String {
    return this.lines()
        .dropWhile { it.isBlank() }
        .dropLastWhile { it.isBlank() }
        .joinToString("\n")
        .trimIndent()
}