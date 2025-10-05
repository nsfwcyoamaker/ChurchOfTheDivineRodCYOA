package com.nsfwcyoamaker.cotdr.presentation.svg

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

val Sword: ImageVector
    get() {
        if (_Sword != null) {
            return _Sword!!
        }
        _Sword = ImageVector.Builder(
            name = "Sword",
            defaultWidth = 300.dp,
            defaultHeight = 57.dp,
            viewportWidth = 300f,
            viewportHeight = 57f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(258.1f, 9.8f)
                curveToRelative(-2.6f, 2.6f, -3.1f, 3.5f, -2.1f, 4.6f)
                curveToRelative(0.6f, 0.8f, 1f, 3.2f, 0.8f, 5.3f)
                lineToRelative(-0.3f, 3.8f)
                lineToRelative(-36.5f, 0.6f)
                curveToRelative(-20.1f, 0.4f, -73.1f, 0.9f, -117.8f, 1.3f)
                curveToRelative(-50.7f, 0.4f, -82.1f, 1f, -83.2f, 1.6f)
                curveToRelative(-1f, 0.6f, -2.6f, 1f, -3.4f, 1f)
                curveToRelative(-0.9f, -0f, -1.6f, 0.4f, -1.6f, 0.9f)
                curveToRelative(0f, 1.3f, 3.7f, 2.4f, 5.1f, 1.5f)
                curveToRelative(0.7f, -0.4f, 0.9f, -0.3f, 0.5f, 0.4f)
                curveToRelative(-0.3f, 0.6f, -0.3f, 1.3f, 0.1f, 1.5f)
                curveToRelative(0.5f, 0.3f, 39.1f, 0.7f, 85.8f, 1.1f)
                curveToRelative(87.6f, 0.6f, 148.1f, 1.5f, 150.3f, 2.2f)
                curveToRelative(1.5f, 0.4f, 1.6f, 7.6f, 0.1f, 9.1f)
                curveToRelative(-0.8f, 0.8f, -0.2f, 1.9f, 2.2f, 4.1f)
                lineToRelative(3.3f, 3f)
                lineToRelative(3.7f, -3.2f)
                curveToRelative(2.9f, -2.4f, 3.5f, -3.3f, 2.3f, -3.9f)
                curveToRelative(-0.9f, -0.5f, -1.4f, -2.4f, -1.4f, -5.2f)
                lineToRelative(0f, -4.5f)
                lineToRelative(8.8f, -0f)
                curveToRelative(4.8f, -0f, 9.3f, 0.5f, 9.8f, 1f)
                curveToRelative(0.7f, 0.7f, 2.4f, -0.2f, 5.2f, -2.9f)
                curveToRelative(4.5f, -4.3f, 5f, -5.1f, 2.8f, -5.1f)
                curveToRelative(-0.8f, -0f, -2.6f, -1.3f, -3.9f, -3f)
                curveToRelative(-2.3f, -2.6f, -2.9f, -2.9f, -5.2f, -2f)
                curveToRelative(-1.4f, 0.6f, -5.8f, 1f, -9.6f, 1f)
                curveToRelative(-6.7f, -0f, -7f, -0.1f, -8f, -2.7f)
                curveToRelative(-0.8f, -2.1f, -0.7f, -3.5f, 0.4f, -5.8f)
                curveToRelative(1.3f, -2.9f, 1.2f, -3.1f, -1.7f, -6f)
                lineToRelative(-3.1f, -3f)
                lineToRelative(-3.4f, 3.3f)
                close()
                moveTo(264.8f, 27.7f)
                curveToRelative(0.2f, 0.9f, -0.8f, 1.3f, -3.2f, 1.3f)
                curveToRelative(-3.4f, -0f, -4.4f, -0.8f, -2.9f, -2.4f)
                curveToRelative(1.1f, -1.1f, 5.6f, -0.2f, 6.1f, 1.1f)
                close()
                moveTo(53f, 30.6f)
                curveToRelative(13.5f, -0.3f, 65f, -0.6f, 114.4f, -0.6f)
                curveToRelative(78.6f, -0f, 90.1f, 0.2f, 91.6f, 1.5f)
                curveToRelative(2.1f, 1.9f, 3.7f, 1.9f, 4.7f, 0.1f)
                curveToRelative(0.6f, -1f, 4.2f, -1.5f, 14.1f, -1.8f)
                lineToRelative(13.3f, -0.4f)
                lineToRelative(-2.9f, 2.8f)
                curveToRelative(-2.5f, 2.5f, -3.2f, 2.8f, -5.6f, 1.8f)
                curveToRelative(-1.5f, -0.5f, -5.4f, -1f, -8.7f, -1f)
                curveToRelative(-8.5f, -0f, -11.6f, 3.5f, -9f, 10.3f)
                curveToRelative(0.8f, 2f, 0.5f, 2.9f, -1.3f, 4.6f)
                lineToRelative(-2.2f, 2.1f)
                lineToRelative(-2.3f, -2.4f)
                curveToRelative(-1.9f, -2f, -2.1f, -2.8f, -1.1f, -4.3f)
                curveToRelative(1f, -1.6f, 1.1f, -1.6f, 0.7f, 0.5f)
                curveToRelative(-0.6f, 2.7f, 1.9f, 4.5f, 4.5f, 3.1f)
                curveToRelative(1.4f, -0.8f, 1.6f, -1.4f, 0.7f, -3.7f)
                curveToRelative(-1.4f, -3.6f, -0.3f, -8.9f, 2.1f, -10.2f)
                curveToRelative(2.3f, -1.2f, 14f, -1.3f, 17.3f, -0.1f)
                curveToRelative(1.9f, 0.7f, 2.6f, 0.5f, 3.6f, -1.1f)
                curveToRelative(1f, -1.6f, 1f, -1.9f, -0.1f, -1.2f)
                curveToRelative(-0.7f, 0.5f, -5.6f, 0.7f, -10.9f, 0.5f)
                curveToRelative(-7.9f, -0.2f, -9.9f, -0f, -11.2f, 1.4f)
                curveToRelative(-2.2f, 2.2f, -3.1f, 5.8f, -2.4f, 10.1f)
                curveToRelative(0.4f, 2.4f, 0.2f, 3.4f, -0.7f, 3.4f)
                curveToRelative(-0.9f, -0f, -1.1f, -1.5f, -0.8f, -5.3f)
                curveToRelative(0.3f, -4.1f, 0f, -5.6f, -1.3f, -6.7f)
                curveToRelative(-1.5f, -1.2f, -1.6f, -1.1f, -1f, 1.6f)
                curveToRelative(0.5f, 2.5f, 0.4f, 2.6f, -0.4f, 0.7f)
                curveToRelative(-0.6f, -1.3f, -1.2f, -2.4f, -1.3f, -2.5f)
                curveToRelative(-0.2f, -0.2f, -28.4f, -0.5f, -62.8f, -0.8f)
                lineToRelative(-62.5f, -0.6f)
                lineToRelative(63.2f, 0.1f)
                curveToRelative(37.2f, -0f, 62.9f, -0.4f, 62.6f, -0.9f)
                curveToRelative(-0.4f, -0.5f, -48.7f, -0.6f, -118.3f, -0.3f)
                curveToRelative(-99.4f, 0.6f, -117.7f, 0.5f, -117.7f, -0.7f)
                curveToRelative(0f, -1.1f, 0.8f, -1.1f, 3.6f, -0.3f)
                curveToRelative(2.3f, 0.6f, 12.6f, 0.7f, 28.1f, 0.3f)
                close()
            }
        }.build()

        return _Sword!!
    }

@Suppress("ObjectPropertyName")
private var _Sword: ImageVector? = null

@Preview
@Composable
private fun SwordPreview() {
    Image(
        rememberVectorPainter(Sword),
        null,
    )
}
