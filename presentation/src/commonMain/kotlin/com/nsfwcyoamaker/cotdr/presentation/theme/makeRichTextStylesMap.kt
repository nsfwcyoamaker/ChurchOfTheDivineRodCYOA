package com.nsfwcyoamaker.cotdr.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import com.nsfwcyoamaker.cotdr.presentation.utils.rich_text.RichStyleTag

@Composable
fun makeRichTextStylesMap(): Map<String, RichStyleTag> {
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
            "weight" to RichStyleTag { attributes ->
                val value = attributes["value"]
                val weight = when(value) {
                    "b" -> FontWeight.Bold
                    "n" -> FontWeight.Normal
                    else -> FontWeight.Normal
                }
                SpanStyle(fontWeight = weight)
            },
            "style" to RichStyleTag { attributes ->
                val value = attributes["value"]
                val style = when(value) {
                    "i" -> FontStyle.Italic
                    "n" -> FontStyle.Normal
                    else -> FontStyle.Normal
                }
                SpanStyle(fontStyle = style)
            },
            "size" to RichStyleTag { attributes ->
                val value = attributes["value"]?.toFloatOrNull() ?: 1f
                SpanStyle(fontSize = value.em)
            },
            "acerolaSpeech" to RichStyleTag { acerolaStyle },
            "celesteSpeech" to RichStyleTag { celesteStyle },
            "desuriSpeech" to RichStyleTag { desuriStyle },
            "erinaSpeech" to RichStyleTag { erinaStyle },
            "helenaSpeech" to RichStyleTag { helenaStyle },
        )
    }
}