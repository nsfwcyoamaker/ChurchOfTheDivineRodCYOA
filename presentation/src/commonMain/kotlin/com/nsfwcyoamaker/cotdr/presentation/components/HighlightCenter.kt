package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.svg.Sword

@Composable
fun HighlightCenter(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
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

        content()

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