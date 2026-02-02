package com.nsfwcyoamaker.cotdr.presentation.components.sections.chapters

import androidx.compose.foundation.lazy.LazyListScope
import com.nsfwcyoamaker.cotdr.presentation.model.ChapterOption

fun LazyListScope.ChaptersItemsGrid() {
    ChapterOption.entries.forEachIndexed { index, option ->
        item(
            key = "chapter_item_row_$index",
            contentType = "chapter_item_row",
        ) {
            ChapterItem(option)
        }
    }
}