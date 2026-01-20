package com.nsfwcyoamaker.cotdr.composableRichText

fun interface TagHandler {
    fun resolve(attributes: Map<String, String>): RichTextStyle?
}