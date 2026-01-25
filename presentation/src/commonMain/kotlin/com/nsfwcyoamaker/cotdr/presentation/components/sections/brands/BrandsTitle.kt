package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_brands_title

@Composable
fun BrandsTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_brands_title,
        modifier = modifier,
    )
}