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
import com.nsfwcyoamaker.cotdr.composableRichText.RichTextStyle
import com.nsfwcyoamaker.cotdr.composableRichText.TagHandler

@Composable
fun makeRichTextStylesMap(): Map<String, TagHandler> {
    val angloStyle = AngloTextStyle.toSpanStyle()
    val angloGlowStyle = AngloGlowTextStyle.toSpanStyle()

    val acerolaStyle = AcerolaTextStyle.toSpanStyle()
    val celesteStyle = CelesteTextStyle.toSpanStyle()
    val desuriStyle = DesuriTextStyle.toSpanStyle()
    val erinaStyle = ErinaTextStyle.toSpanStyle()
    val helenaStyle = HelenaTextStyle.toSpanStyle()
    val bambinaStyle = BambinaTextStyle.toSpanStyle()
    val fuukaStyle = FuukaTextStyle.toSpanStyle()
    val sophiaStyle = SophiaTextStyle.toSpanStyle()
    val gracidiaStyle = GracidiaTextStyle.toSpanStyle()
    val sashaStyle = SashaTextStyle.toSpanStyle()
    val teresaStyle = TeresaTextStyle.toSpanStyle()

    val acerolaTitleStyle = AcerolaTitleTextStyle.toSpanStyle()
    val celesteTitleStyle = CelesteTitleTextStyle.toSpanStyle()
    val desuriTitleStyle = DesuriTitleTextStyle.toSpanStyle()
    val erinaTitleStyle = ErinaTitleTextStyle.toSpanStyle()
    val helenaTitleStyle = HelenaTitleTextStyle.toSpanStyle()

    return remember(
        angloStyle,
        angloGlowStyle,

        acerolaStyle,
        celesteStyle,
        desuriStyle,
        erinaStyle,
        helenaStyle,

        acerolaTitleStyle,
        celesteTitleStyle,
        desuriTitleStyle,
        erinaTitleStyle,
        helenaTitleStyle,
    ) {
        mapOf(
            "b" to TagHandler { RichTextStyle(spanStyle = SpanStyle(fontWeight = FontWeight.Bold)) },
            "i" to TagHandler { RichTextStyle(spanStyle = SpanStyle(fontStyle = FontStyle.Italic)) },
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

            "anglo" to TagHandler { RichTextStyle(spanStyle = angloStyle) },
            "angloGlow" to TagHandler { RichTextStyle(spanStyle = angloGlowStyle) },

            "acerola" to TagHandler { RichTextStyle(spanStyle = acerolaStyle) },
            "celeste" to TagHandler { RichTextStyle(spanStyle = celesteStyle) },
            "desuri" to TagHandler { RichTextStyle(spanStyle = desuriStyle) },
            "erina" to TagHandler { RichTextStyle(spanStyle = erinaStyle) },
            "helena" to TagHandler { RichTextStyle(spanStyle = helenaStyle) },
            "bambina" to TagHandler { RichTextStyle(spanStyle = bambinaStyle) },
            "fuuka" to TagHandler { RichTextStyle(spanStyle = fuukaStyle) },
            "sophia" to TagHandler { RichTextStyle(spanStyle = sophiaStyle) },
            "gracidia" to TagHandler { RichTextStyle(spanStyle = gracidiaStyle) },
            "sasha" to TagHandler { RichTextStyle(spanStyle = sashaStyle) },
            "teresa" to TagHandler { RichTextStyle(spanStyle = teresaStyle) },

            "acerolaTitle" to TagHandler { RichTextStyle(spanStyle = acerolaTitleStyle) },
            "celesteTitle" to TagHandler { RichTextStyle(spanStyle = celesteTitleStyle) },
            "desuriTitle" to TagHandler { RichTextStyle(spanStyle = desuriTitleStyle) },
            "erinaTitle" to TagHandler { RichTextStyle(spanStyle = erinaTitleStyle) },
            "helenaTitle" to TagHandler { RichTextStyle(spanStyle = helenaTitleStyle) },
        )
    }
}