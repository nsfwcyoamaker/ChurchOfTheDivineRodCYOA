package com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_fervor_title

@Composable
fun FervorTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_fervor_title,
        modifier = modifier,
    )
}