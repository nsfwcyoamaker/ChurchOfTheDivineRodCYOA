package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.divider_horizontal_edge
import com.nsfwcyoamaker.cotdr.resources.section_fervor_title
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionSubTitle(
    title: StringResource,
    modifier: Modifier = Modifier,
) {
    HighlightCenter(
        modifier = modifier,
        iconSize = 24.dp,
        highlightContent = { modifier ->
            Image(
                painter = painterResource(Res.drawable.divider_horizontal_edge),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = modifier,
            )
        }
    ) {
        Text(
            text = rememberRichTextResource(title),
            maxLines = 1,
            style = smallTitleTextStyle,
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun SectionSubTitlePreview() {
    SectionSubTitle(
        title = Res.string.section_fervor_title,
        modifier = Modifier.background(Color.Black)
    )
}