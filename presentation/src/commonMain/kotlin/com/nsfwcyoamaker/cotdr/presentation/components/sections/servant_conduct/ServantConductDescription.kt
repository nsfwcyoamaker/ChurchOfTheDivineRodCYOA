package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_servant_conduct_description

@Composable
fun ServantConductDescription(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.section_servant_conduct_description),
        modifier = modifier,
    )
}