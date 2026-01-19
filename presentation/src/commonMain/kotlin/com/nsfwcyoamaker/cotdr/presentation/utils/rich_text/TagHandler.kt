package com.nsfwcyoamaker.cotdr.presentation.utils.rich_text

fun interface TagHandler {
    fun resolve(attributes: Map<String, String>): RichTextStyle?
}