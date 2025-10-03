package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A custom modifier that draws a solid color overlay around the borders of a composable.
 *
 * This is the most efficient approach as it uses `drawWithContent` to add to the drawing
 * phase without affecting layout or composition.
 *
 * The effect is created by drawing a path with an EvenOdd fill type, which essentially
 * cuts a hole in a larger rectangle, leaving only the border. This avoids overlapping
 * corners.
 *
 * @param strokeWidth The width of the border.
 * @param color The color of the border.
 * @param alpha The alpha of the border color.
 */
@Composable
fun Modifier.shadowBorder(
    strokeWidth: Dp = 6.dp,
    color: Color = Color.Black,
    alpha: Float = 0.35f
): Modifier = composed {
    val strokeWidthPx = with(LocalDensity.current) { strokeWidth.toPx() }
    val shadowColor = color.copy(alpha = alpha)

    drawWithContent {
        drawContent()

        val path = Path().apply {
            addRect(Rect(Offset.Zero, size))
            addRect(
                Rect(
                    offset = Offset(strokeWidthPx, strokeWidthPx),
                    size = Size(
                        width = (size.width - strokeWidthPx * 2).coerceAtLeast(0f),
                        height = (size.height - strokeWidthPx * 2).coerceAtLeast(0f)
                    )
                )
            )
            fillType = PathFillType.EvenOdd
        }

        drawPath(path = path, color = shadowColor)
    }
}

/**
 * A preview to demonstrate the `shadowBorder` modifier in action on various shapes
 * and with different parameters.
 */
@Preview(showBackground = true)
@Composable
private fun ShadowBorderPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Shadow Border Modifier", fontSize = 22.sp, color = Color.DarkGray)

        // --- Example 0: Square with default values ---
        Text("Applied to a square placeholder, default values:")
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray)
                .shadowBorder()
        ) {
            // Your Image would go here
            Text("Content", Modifier.align(Alignment.Center), color = Color.Black)
        }

        // --- Example 1: Square with a larger stroke width ---
        Text("Applied to a square placeholder, with larger stroke:")
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Cyan)
                .shadowBorder(strokeWidth = 12.dp, alpha = 0.75f)
        ) {
            // Your Image would go here
            Text("Content", Modifier.align(Alignment.Center), color = Color.Black)
        }

        // --- Example 2: Clipped, rounded-corner shape with a custom color ---
        Text("Applied to a clipped, rounded-corner shape:")
        Box(
            modifier = Modifier
                .size(150.dp)
                // Note: The clip modifier is applied *before* our shadowBorder.
                // The drawing from shadowBorder happens *after* clipping the content,
                // but it draws over the full rectangular bounds of the composable.
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Magenta)
                .shadowBorder(strokeWidth = 20.dp, color = Color.Blue, alpha = 0.6f)
        ) {
            Text("Clipped Content", Modifier.align(Alignment.Center), color = Color.White)
        }

        // --- Example 3: Clipped, circular shape with default values ---
        Text("Applied to a clipped, circular shape:")
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(Color.Yellow)
                .shadowBorder() // Using default values
        ) {
            Text("Circular", Modifier.align(Alignment.Center), color = Color.Black)
        }
    }
}