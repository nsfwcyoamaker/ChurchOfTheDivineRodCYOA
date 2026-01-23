package com.nsfwcyoamaker.cotdr.presentation.components.sections.covenants

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_covenants_title

@Composable
fun CovenantsTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_covenants_title,
        modifier = modifier,
    )
}