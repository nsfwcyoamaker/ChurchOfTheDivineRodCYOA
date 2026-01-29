package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_servant_conduct_title

@Composable
fun ServantConductTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_servant_conduct_title,
        modifier = modifier,
    )
}