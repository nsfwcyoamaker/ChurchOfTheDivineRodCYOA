package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.PreviewScope
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.priestesses_introduction_extra_2
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PriestessIntroductionExtra2(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.priestesses_introduction_extra_2),
        modifier = modifier,
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun PriestessIntroductionExtra2Preview() {
    PreviewScope {
        PriestessIntroductionExtra2()
    }
}