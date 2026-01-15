package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.svg.Sword
import com.nsfwcyoamaker.cotdr.presentation.theme.sectionTitleTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    val iconSize = 64.dp
    val iconColor = Color.White

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Icon(
                painter = rememberVectorPainter(Sword),
                contentDescription = null,
                modifier = Modifier.height(iconSize),
                tint = iconColor,
            )
        }

        Text(
            text = title,
            maxLines = 1,
            style = sectionTitleTextStyle,
        )

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterStart,
        ) {
            Icon(
                painter = rememberVectorPainter(Sword),
                contentDescription = null,
                modifier = Modifier.height(iconSize).scale(scaleX = -1f, scaleY = 1f),
                tint = iconColor,
            )
        }
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