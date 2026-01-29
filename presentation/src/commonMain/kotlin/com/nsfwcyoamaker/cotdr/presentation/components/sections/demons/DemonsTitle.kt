package com.nsfwcyoamaker.cotdr.presentation.components.sections.demons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_demons_title

@Composable
fun DemonsTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_demons_title,
        modifier = modifier,
    )
}