package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_rulings_title

@Composable
fun RulingsTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_rulings_title,
        modifier = modifier,
    )
}