package com.nsfwcyoamaker.cotdr.presentation.components.sections.chapters

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_chapters_title

@Composable
fun ChaptersTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_chapters_title,
        modifier = modifier,
    )
}