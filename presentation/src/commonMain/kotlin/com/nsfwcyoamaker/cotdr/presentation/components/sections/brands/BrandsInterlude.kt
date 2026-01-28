package com.nsfwcyoamaker.cotdr.presentation.components.sections.brands

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_brands_interlude

@Composable
fun BrandsInterlude(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.section_brands_interlude),
        modifier = modifier,
    )
}