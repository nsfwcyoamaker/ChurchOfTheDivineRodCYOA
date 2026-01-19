package com.nsfwcyoamaker.cotdr.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.RichTextStyle
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.TagHandler

@Composable
fun makeRichTextStylesMap(): Map<String, TagHandler> {
    val acerolaStyle = acerolaTextStyle.toSpanStyle()
    val celesteStyle = celesteTextStyle.toSpanStyle()
    val desuriStyle = desuriTextStyle.toSpanStyle()
    val erinaStyle = erinaTextStyle.toSpanStyle()
    val helenaStyle = helenaTextStyle.toSpanStyle()

    return remember(
        acerolaStyle,
        celesteStyle,
        desuriStyle,
        erinaStyle,
        helenaStyle,
    ) {
        mapOf(
            "weight" to TagHandler { attributes ->
                val value = attributes["value"]
                val weight = when(value) {
                    "b" -> FontWeight.Bold
                    "n" -> FontWeight.Normal
                    else -> FontWeight.Normal
                }
                RichTextStyle(spanStyle = SpanStyle(fontWeight = weight))
            },
            "style" to TagHandler { attributes ->
                val value = attributes["value"]
                val style = when(value) {
                    "i" -> FontStyle.Italic
                    "n" -> FontStyle.Normal
                    else -> FontStyle.Normal
                }
                RichTextStyle(spanStyle = SpanStyle(fontStyle = style))
            },
            "size" to TagHandler { attributes ->
                val value = attributes["value"]?.toFloatOrNull() ?: 1f
                RichTextStyle(spanStyle = SpanStyle(fontSize = value.em))
            },
            "indent" to TagHandler { attributes ->
                val depth = attributes["depth"]?.toDoubleOrNull() ?: 20.0

                RichTextStyle(
                    paragraphStyle = ParagraphStyle(
                        textIndent = TextIndent(
                            firstLine = 0.sp,
                            restLine = depth.sp
                        )
                    )
                )
            },
            "emphasis" to TagHandler { attributes ->
                val size = attributes["size"]?.toDoubleOrNull() ?: 1.1
                RichTextStyle(SpanStyle(fontSize = size.em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal))
            },
            "acerolaSpeech" to TagHandler { RichTextStyle(spanStyle = acerolaStyle) },
            "celesteSpeech" to TagHandler { RichTextStyle(spanStyle = celesteStyle) },
            "desuriSpeech" to TagHandler { RichTextStyle(spanStyle = desuriStyle) },
            "erinaSpeech" to TagHandler { RichTextStyle(spanStyle = erinaStyle) },
            "helenaSpeech" to TagHandler { RichTextStyle(spanStyle = helenaStyle) },
        )
    }
}