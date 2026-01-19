package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.PreviewScope
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_priestesses_introduction_description
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PriestessIntroductionDescription(
    modifier: Modifier = Modifier,
) {
    Text(
        text = rememberRichTextResource(Res.string.section_priestesses_introduction_description),
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Color.White,
        ),
        modifier = modifier,
    )
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun PriestessIntroductionDescriptionPreview() {
    PreviewScope {
        PriestessIntroductionDescription()
    }
}