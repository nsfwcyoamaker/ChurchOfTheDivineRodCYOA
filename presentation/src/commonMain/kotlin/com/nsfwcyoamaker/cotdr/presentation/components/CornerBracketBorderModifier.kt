package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.cornerBracketBorder(
    color: Color = Color.White,
    strokeWidth: Dp = 6.dp,
    horizontalArmLength: Dp = 30.dp, // Shorter arm
    verticalArmLength: Dp = 80.dp,   // Longer arm
    tipSlant: Dp = 6.dp              // The angle cut at the ends
) = this.then(
    Modifier.drawWithCache {
        val strokeWidthPx = strokeWidth.toPx()
        val hArmPx = horizontalArmLength.toPx()
        val vArmPx = verticalArmLength.toPx()
        val tipSlantPx = tipSlant.toPx()

        val path = Path().apply {
            // scaleX/Y: 1 for Top/Left, -1 for Bottom/Right
            fun addCorner(scaleX: Float, scaleY: Float) {
                // Origin point for this corner (0,0 or width,0 etc)
                val originX = if (scaleX == 1f) 0f else size.width
                val originY = if (scaleY == 1f) 0f else size.height

                // Direction multipliers
                val dirX = if (scaleX == 1f) 1f else -1f
                val dirY = if (scaleY == 1f) 1f else -1f

                // 1. Start at the bottom of the vertical tip
                moveTo(originX, originY + (vArmPx * dirY))

                // 2. Draw line to the extreme outer corner
                lineTo(originX, originY)

                // 3. Draw line to the end of horizontal tip
                lineTo(originX + (hArmPx * dirX), originY)

                // 4. Inner Return (Horizontal) - creates the slant/bevel
                lineTo(
                    originX + ((hArmPx - tipSlantPx) * dirX),
                    originY + (strokeWidthPx * dirY)
                )

                // 5. Inner Corner
                lineTo(
                    originX + (strokeWidthPx * dirX),
                    originY + (strokeWidthPx * dirY)
                )

                // 6. Inner Return (Vertical) - creates the slant/bevel
                lineTo(
                    originX + (strokeWidthPx * dirX),
                    originY + ((vArmPx - tipSlantPx) * dirY)
                )

                close()
            }

            // Draw all 4 corners
            addCorner(1f, 1f)   // Top-Left
            addCorner(-1f, 1f)  // Top-Right
            addCorner(1f, -1f)  // Bottom-Left
            addCorner(-1f, -1f) // Bottom-Right
        }

        onDrawWithContent {
            drawContent()
            drawPath(path, color, style = Fill)
        }
    }
)