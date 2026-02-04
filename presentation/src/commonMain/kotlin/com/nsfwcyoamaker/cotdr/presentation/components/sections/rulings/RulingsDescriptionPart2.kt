package com.nsfwcyoamaker.cotdr.presentation.components.sections.rulings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_rulings_description_part_2

@Composable
fun RulingsDescriptionPart2(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.section_rulings_description_part_2),
        modifier = modifier,
    )
}