package com.nsfwcyoamaker.cotdr.composableTextFlow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextFlow(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    placement: TextWrapPlacement = TextWrapPlacement.TopEnd,
    horizontalGap: Dp = 8.dp,
    verticalGap: Dp = 8.dp,
    style: TextStyle = LocalTextStyle.current,
    component: @Composable () -> Unit
) {
    val textMeasurer = rememberTextMeasurer()

    val refinedStyle = style.merge(
        TextStyle(
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Proportional,
                trim = LineHeightStyle.Trim.Both
            )
        )
    )

    SubcomposeLayout(modifier = modifier) { constraints ->
        val horizontalGapPx = horizontalGap.roundToPx()
        val verticalGapPx = verticalGap.roundToPx()
        val maxWidth = constraints.maxWidth

        // --- PHASE 1: Measure Component (Auto Width) ---
        // We give the component loose constraints so it can decide its own size.
        // It can be up to 50% of the total width (arbitrary safety limit) or full width.
        // Usually, images have an intrinsic size or a specific modifier size.
        val componentConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0
        )

        val componentPlaceable = subcompose("component", component)
            .first()
            .measure(componentConstraints)

        val componentWidthPx = componentPlaceable.width
        val componentHeightPx = componentPlaceable.height

        // --- PHASE 2: Measure & Split Text ---
        // Calculate remaining width for text
        val sideTextWidthPx = (maxWidth - componentWidthPx - horizontalGapPx).coerceAtLeast(0)

        val textLayoutResult = textMeasurer.measure(
            text = text,
            style = refinedStyle,
            constraints = Constraints(maxWidth = sideTextWidthPx)
        )

        // GREEDY LOGIC + Vertical Gap check
        var cutIndex = text.length
        // The text needs to clear the Image Height + Vertical Gap
        val obstacleBottom = componentHeightPx + verticalGapPx

        for (line in 0 until textLayoutResult.lineCount) {
            // If the line STARTS below the (Image + Vertical Gap), it belongs to the bottom block
            if (textLayoutResult.getLineTop(line) >= obstacleBottom) {
                cutIndex = textLayoutResult.getLineStart(line)
                break
            }
        }

        val topText = text.subSequence(0, cutIndex)
        val rawBottomText = if (cutIndex < text.length) text.subSequence(cutIndex, text.length) else AnnotatedString("")
        val bottomText = rawBottomText.trimStart()

        // --- PHASE 3: Measure Text Blocks ---
        val topTextPlaceable = subcompose("topText") {
            Text(text = topText, style = refinedStyle)
        }.first().measure(Constraints(maxWidth = sideTextWidthPx))

        val bottomTextPlaceable = if (bottomText.isNotEmpty()) {
            subcompose("bottomText") {
                Text(text = bottomText, style = refinedStyle)
            }.first().measure(constraints.copy(minWidth = 0)) // Full width available
        } else null

        // --- PHASE 4: Position ---
        // The "Top Block" height is determined by the taller of the two:
        // 1. The Image height + Vertical Gap
        // 2. The actual text that fit next to the image
        val topBlockHeight = maxOf(obstacleBottom, topTextPlaceable.height)

        val totalHeight = topBlockHeight + (bottomTextPlaceable?.height ?: 0)

        layout(width = maxWidth, height = totalHeight) {
            val isImageRight = placement == TextWrapPlacement.TopEnd

            // 1. Place Component
            componentPlaceable.place(
                x = if (isImageRight) maxWidth - componentWidthPx else 0,
                y = 0
            )

            // 2. Place Top Text
            topTextPlaceable.place(
                x = if (isImageRight) 0 else componentWidthPx + horizontalGapPx,
                y = 0
            )

            // 3. Place Bottom Text
            // It starts exactly where the "Top Block" ends
            bottomTextPlaceable?.place(x = 0, y = topBlockHeight)
        }
    }
}

/**
 * Helper to trim leading whitespace from an AnnotatedString while preserving spans.
 */
private fun AnnotatedString.trimStart(): AnnotatedString {
    val index = this.text.indexOfFirst { !it.isWhitespace() }
    return if (index == -1) AnnotatedString("") else this.subSequence(index, this.length)
}

@Preview
@Composable
private fun TextFlowPreview() {
    val richText = buildAnnotatedString {
        append("This is a standard text start. ")
        withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
            append("This part is BOLD and RED. ")
        }
        append("Here is a lot more text to demonstrate the wrapping capability. ")
        append("The text should flow normally next to the image until it exceeds the image height, ")
        append("at which point it should seamlessly wrap underneath the image and span the full width ")
        append("of the container. This works on Android, iOS, Desktop, and WasmJS!")
        append("of the container. This works on Android, iOS, Desktop, and WasmJS!")
        append("of the container. This works on Android, iOS, Desktop, and WasmJS!")
        append("of the container. This works on Android, iOS, Desktop, and WasmJS!")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        TextFlow(
            text = richText,
            placement = TextWrapPlacement.TopEnd,
            component = {
                Box(Modifier.requiredSize(100.dp, 123.dp).background(Color.Gray))
            }
        )

        TextFlow(
            text = richText,
            placement = TextWrapPlacement.TopStart,
            component = {
                Box(Modifier.requiredSize(100.dp, 123.dp).background(Color.Gray))
            }
        )
    }
}