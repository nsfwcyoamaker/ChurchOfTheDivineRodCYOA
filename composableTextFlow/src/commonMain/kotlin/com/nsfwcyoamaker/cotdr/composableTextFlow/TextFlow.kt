package com.nsfwcyoamaker.cotdr.composableTextFlow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextFlow(
    text: AnnotatedString,
    componentSize: DpSize,
    modifier: Modifier = Modifier,
    placement: TextWrapPlacement = TextWrapPlacement.TopEnd,
    gap: Dp = 8.dp, // Space between text and component
    style: TextStyle = LocalTextStyle.current,
    component: @Composable BoxScope.() -> Unit
) {
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current

    BoxWithConstraints(modifier = modifier) {
        val maxWidth = constraints.maxWidth
        val componentWidthPx = with(density) { componentSize.width.toPx() }
        val componentHeightPx = with(density) { componentSize.height.toPx() }
        val gapPx = with(density) { gap.toPx() }

        // 1. Calculate available width for the text next to the component
        // We subtract the component width AND the gap
        val sideTextWidthPx = (maxWidth - componentWidthPx - gapPx).coerceAtLeast(0f)

        // 2. Measure the text as if it were entirely in the narrow side column
        // We do this to find exactly which line exceeds the component's height
        val textLayoutResult = remember(text, style, sideTextWidthPx) {
            textMeasurer.measure(
                text = text,
                style = style,
                constraints = Constraints(maxWidth = sideTextWidthPx.toInt())
            )
        }

        // 3. Find the "Cut Point" (index)
        val cutIndex = remember(textLayoutResult, componentHeightPx) {
            var splitIndex = text.length
            // Iterate through lines to find the one that overflows the component height
            for (lineIndex in 0 until textLayoutResult.lineCount) {
                if (textLayoutResult.getLineBottom(lineIndex) > componentHeightPx) {
                    // The previous line was the last one that fits
                    val lastFittingLine = (lineIndex - 1).coerceAtLeast(0)

                    // If even the first line doesn't fit (giant text/tiny image), we cut at 0
                    if (textLayoutResult.getLineBottom(0) > componentHeightPx) {
                        splitIndex = 0
                    } else {
                        splitIndex = textLayoutResult.getLineEnd(lastFittingLine, visibleEnd = true)
                    }
                    break
                }
            }
            splitIndex
        }

        // 4. Split the AnnotatedString
        // subSequence preserves styles (SpanStyles/ParagraphStyles)
        val topText = text.subSequence(0, cutIndex)
        val bottomText = if (cutIndex < text.length) text.subSequence(cutIndex, text.length) else AnnotatedString("")

        // 5. Render
        Column {
            // -- TOP SECTION --
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                if (placement == TextWrapPlacement.TopStart) {
                    // [Component] [Gap] [Text]
                    Box(modifier = Modifier.size(componentSize)) { component() }
                    Spacer(modifier = Modifier.width(gap))
                    Text(
                        text = topText,
                        style = style,
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = componentSize.height) // Ensure row is at least image height
                    )
                } else {
                    // [Text] [Gap] [Component]
                    Text(
                        text = topText,
                        style = style,
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = componentSize.height)
                    )
                    Spacer(modifier = Modifier.width(gap))
                    Box(modifier = Modifier.size(componentSize)) { component() }
                }
            }

            // -- BOTTOM SECTION --
            if (bottomText.isNotEmpty()) {
                Text(
                    text = bottomText,
                    style = style,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun TextFlowPreview() {
    val richText = buildAnnotatedString {
        append("This is a standard text start. ")
        withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
            append("This part is BOLD and RED. ")
        }
        append("Here is a lot more text to demonstrate the wrapping capability. ")
        append("The text should flow normally next to the image until it exceeds the image height, ")
        append("at which point it should seamlessly wrap underneath the image and span the full width ")
        append("of the container. This works on Android, iOS, Desktop, and WasmJS!")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        TextFlow(
            text = richText,
            componentSize = DpSize(100.dp, 100.dp),
            placement = TextWrapPlacement.TopEnd,
            component = {
                Box(Modifier.fillMaxSize().background(Color.Gray))
            }
        )

        TextFlow(
            text = richText,
            componentSize = DpSize(100.dp, 100.dp),
            placement = TextWrapPlacement.TopStart,
            component = {
                Box(Modifier.fillMaxSize().background(Color.Gray))
            }
        )
    }
}
