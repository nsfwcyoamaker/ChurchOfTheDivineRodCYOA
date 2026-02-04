package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.svg.Sword
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HighlightCenter(
    modifier: Modifier = Modifier,
    inverted: Boolean = false,
    iconSize: Dp = 64.dp,
    highlightContent: @Composable (modifier: Modifier) -> Unit = { modifier ->
        Icon(
            painter = rememberVectorPainter(Sword),
            contentDescription = null,
            modifier = modifier,
            tint = Color.White,
        )
    },
    content: @Composable RowScope.() -> Unit,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd,
        ) {
            highlightContent(
                Modifier
                    .height(iconSize)
                    .then(
                        if(inverted) Modifier.scale(scaleX = -1f, scaleY = 1f) else Modifier
                    )
            )
        }

        content()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterStart,
        ) {
            highlightContent(
                Modifier
                    .height(iconSize)
                    .then(
                        if(!inverted) Modifier.scale(scaleX = -1f, scaleY = 1f) else Modifier
                    )
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun HighlightCenterPreview() {
    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        HighlightCenter(
            inverted = false,
        ) {
            Text("Test")
        }
        HighlightCenter(
            inverted = true,
        ) {
            Text("Test")
        }
    }

}