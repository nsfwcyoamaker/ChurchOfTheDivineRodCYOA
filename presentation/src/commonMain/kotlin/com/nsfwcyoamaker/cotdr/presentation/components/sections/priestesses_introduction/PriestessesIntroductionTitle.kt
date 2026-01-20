package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.priestesses_introduction_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun PriestessesIntroductionTitle(
    modifier: Modifier = Modifier,
) {
    SectionTitle(
        title = stringResource(Res.string.priestesses_introduction_title),
        modifier = modifier,
    )
}