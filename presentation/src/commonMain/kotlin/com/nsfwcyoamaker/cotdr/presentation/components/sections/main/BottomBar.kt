package com.nsfwcyoamaker.cotdr.presentation.components.sections.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.theme.captionTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.defaultTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

private object CyoaColors {
    val BackgroundSlate = Color(0xBF0E0E0E)
    val BorderSilver = Color(0xFFA0A0A0)

    val FervorCold = Color(0xFF7AB4D0)
    val FervorNeutral = Color.White
    val FervorHot = Color(0xFFC96D9F)
}

@Composable
fun CyoaBottomBar(
    currentFervor: Int,
    minValue: Int = -30,
    maxValue: Int = 30,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(CyoaColors.BackgroundSlate)
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val borderY = strokeWidth / 2

                // 1. Draw main top silver line
                drawLine(
                    color = CyoaColors.BorderSilver,
                    start = Offset(0f, borderY),
                    end = Offset(size.width, borderY),
                    strokeWidth = 1.dp.toPx() // Thin top line
                )

                // 2. Draw secondary darker line just below it
                drawLine(
                    color = Color.Black.copy(alpha = 0.5f),
                    start = Offset(0f, borderY + 4.dp.toPx()),
                    end = Offset(size.width, borderY + 4.dp.toPx()),
                    strokeWidth = 2.dp.toPx()
                )
            }
            .padding(bottom = 6.dp, top = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(620.dp)
                .wrapContentHeight()
                .align(Alignment.Center)
        ) {
            FervorGauge(
                value = currentFervor,
                min = minValue,
                max = maxValue,
            )
        }
    }
}

@Composable
fun FervorGauge(
    value: Int,
    min: Int,
    max: Int,
    modifier: Modifier = Modifier
) {
    // Normalize value to 0..1 float for the slider position
    val range = max - min
    val normalized = (value - min).toFloat() / range
    val animatedProgress by animateFloatAsState(targetValue = normalized)
    val animatedTextColor by animateColorAsState(targetValue = if(value > 0) CyoaColors.FervorHot else if(value < 0) CyoaColors.FervorCold else CyoaColors.FervorNeutral)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Label
        Text(
            text = "FERVOR",
            style = captionTextStyle
                .copy(
                    shadow = Shadow(
                        color = Color.White,
                        offset = Offset.Zero,
                        blurRadius = 24f,
                    )
                )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // The Visual Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // 1. Draw the Gradient Track
                val gradientBrush = Brush.horizontalGradient(
                    0.0f to CyoaColors.FervorCold,
                    0.5f to CyoaColors.FervorNeutral,
                    1.0f to CyoaColors.FervorHot
                )

                // Track Background
                drawRoundRect(
                    brush = gradientBrush,
                    size = size,
                    cornerRadius = CornerRadius(6.dp.toPx())
                )

                // Track Border
                drawRoundRect(
                    color = Color.Black.copy(alpha = 0.6f),
                    size = size,
                    cornerRadius = CornerRadius(6.dp.toPx()),
                    style = Stroke(width = 1.dp.toPx())
                )

                // 2. Center Tick Mark (Zero point)
                drawLine(
                    color = Color.Black.copy(alpha = 0.5f),
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = 2.dp.toPx()
                )

                // 3. The Needle / Indicator
                val indicatorX = size.width * animatedProgress

                // Draw a simple Diamond shape for the needle
                val needleSize = 8.dp.toPx()
                val needlePath = Path().apply {
                    moveTo(indicatorX, -needleSize) // Top
                    lineTo(indicatorX + needleSize/2, size.height / 2) // Middle Right
                    lineTo(indicatorX, size.height + needleSize) // Bottom
                    lineTo(indicatorX - needleSize/2, size.height / 2) // Middle Left
                    close()
                }

                drawPath(needlePath, Color.White)
                drawPath(needlePath, Color.Black, style = Stroke(1.dp.toPx()))
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = (if (value > 0) "+$value" else "$value"),
            style = defaultTextStyle
                .copy(color = animatedTextColor)
        )
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BottomBarPreview() {
    AppScope {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize(),
        ) {
            CyoaBottomBar(
                0,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }
}