package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nsfwcyoamaker.cotdr.presentation.theme.mediumTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_fervor_title
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionTitle(
    title: StringResource,
    modifier: Modifier = Modifier,
) {
    HighlightCenter(modifier = modifier) {
        Text(
            text = rememberRichTextResource(title),
            maxLines = 1,
            style = mediumTitleTextStyle,
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun SectionTitlePreview() {
    SectionTitle(
        title = Res.string.section_fervor_title,
        modifier = Modifier.background(Color.Black)
    )
}