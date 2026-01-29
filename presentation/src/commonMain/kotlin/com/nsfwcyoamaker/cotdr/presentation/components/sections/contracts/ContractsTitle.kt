package com.nsfwcyoamaker.cotdr.presentation.components.sections.contracts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_contracts_title

@Composable
fun ContractsTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = Res.string.section_contracts_title,
        modifier = modifier,
    )
}