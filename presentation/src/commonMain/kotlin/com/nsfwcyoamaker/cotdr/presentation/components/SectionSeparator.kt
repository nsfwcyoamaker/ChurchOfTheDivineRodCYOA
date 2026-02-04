package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.divider_horizontal
import com.nsfwcyoamaker.cotdr.resources.section_fervor_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionSeparator(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(Res.drawable.divider_horizontal),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = modifier
            .height(24.dp)
            .wrapContentWidth(),
    )
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