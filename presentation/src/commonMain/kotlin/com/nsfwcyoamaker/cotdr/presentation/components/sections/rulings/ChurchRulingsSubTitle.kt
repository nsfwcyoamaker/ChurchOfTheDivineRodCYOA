package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionSubTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_rulings_church_title

@Composable
fun ChurchRulingsSubTitle(
    modifier: Modifier = Modifier,
) {
    SectionSubTitle(
        title = Res.string.section_rulings_church_title,
        modifier = modifier,
    )
}