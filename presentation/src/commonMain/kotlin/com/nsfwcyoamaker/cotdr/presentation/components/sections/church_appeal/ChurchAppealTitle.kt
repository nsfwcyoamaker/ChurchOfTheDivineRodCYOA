package com.nsfwcyoamaker.cotdr.presentation.components.sections.church_appeal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_church_appeal_title

@Composable
fun ChurchAppealTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_church_appeal_title,
        modifier = modifier,
    )
}