package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nsfwcyoamaker.cotdr.presentation.theme.sectionTitleTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    HighlightCenter(modifier = modifier) {
        Text(
            text = title,
            maxLines = 1,
            style = sectionTitleTextStyle,
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
        title = "Followers",
        modifier = Modifier.background(Color.Black)
    )
}