package com.nsfwcyoamaker.cotdr.presentation.components.sections.history

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_history_title

@Composable
fun HistoryTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_history_title,
        modifier = modifier,
    )
}