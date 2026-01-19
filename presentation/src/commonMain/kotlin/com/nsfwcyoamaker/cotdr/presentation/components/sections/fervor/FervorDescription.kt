package com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextFlow
import com.nsfwcyoamaker.cotdr.composableTextFlow.TextWrapPlacement
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun FervorDescription(
    modifier: Modifier = Modifier,
) {
    //todo change the text.

    val intro_paragraph_1_part_1_bigger = stringResource(Res.string.intro_paragraph_1_part_1_bigger)
    val intro_paragraph_1_part_2 = stringResource(Res.string.intro_paragraph_1_part_2)
    val intro_paragraph_2_part_1_normal = stringResource(Res.string.intro_paragraph_2_part_1_normal)
    val intro_paragraph_2_part_2_acerola = stringResource(Res.string.intro_paragraph_2_part_2_acerola)
    val intro_paragraph_3_part_1_normal = stringResource(Res.string.intro_paragraph_3_part_1_normal)
    val intro_paragraph_3_part_2_acerola = stringResource(Res.string.intro_paragraph_3_part_2_acerola)
    val intro_paragraph_3_part_3_acerola_bold = stringResource(Res.string.intro_paragraph_3_part_3_acerola_bold)
    val intro_paragraph_3_part_4_acerola = stringResource(Res.string.intro_paragraph_3_part_4_acerola)
    val intro_paragraph_3_part_5_acerola_bold = stringResource(Res.string.intro_paragraph_3_part_5_acerola_bold)
    val intro_paragraph_3_part_6_acerola = stringResource(Res.string.intro_paragraph_3_part_6_acerola)
    val intro_paragraph_3_part_7_acerola_bold = stringResource(Res.string.intro_paragraph_3_part_7_acerola_bold)
    val intro_paragraph_3_part_8_acerola = stringResource(Res.string.intro_paragraph_3_part_8_acerola)
    val intro_paragraph_4_part_1_acerola = stringResource(Res.string.intro_paragraph_4_part_1_acerola)
    val intro_paragraph_4_part_2_normal = stringResource(Res.string.intro_paragraph_4_part_2_normal)
    val intro_paragraph_4_part_3_acerola = stringResource(Res.string.intro_paragraph_4_part_3_acerola)
    val intro_paragraph_5_part_1_acerola = stringResource(Res.string.intro_paragraph_5_part_1_acerola)
    val intro_paragraph_5_part_2_normal = stringResource(Res.string.intro_paragraph_5_part_2_normal)

    val acerolaSpanStyle = acerolaTextStyle.toSpanStyle()

    val text = remember(
        intro_paragraph_1_part_1_bigger,
        intro_paragraph_1_part_2,
        intro_paragraph_2_part_1_normal,
        intro_paragraph_2_part_2_acerola,
        intro_paragraph_3_part_1_normal,
        intro_paragraph_3_part_2_acerola,
        intro_paragraph_3_part_3_acerola_bold,
        intro_paragraph_3_part_4_acerola,
        intro_paragraph_3_part_5_acerola_bold,
        intro_paragraph_3_part_6_acerola,
        intro_paragraph_3_part_7_acerola_bold,
        intro_paragraph_3_part_8_acerola,
        intro_paragraph_4_part_1_acerola,
        intro_paragraph_4_part_2_normal,
        intro_paragraph_4_part_3_acerola,
        intro_paragraph_5_part_1_acerola,
        intro_paragraph_5_part_2_normal,
    ) {
        buildAnnotatedString {
            withStyle(ParagraphStyle()) {
                withStyle(SpanStyle(fontSize = (1.1).em)) {
                    append(intro_paragraph_1_part_1_bigger)
                }
                append(intro_paragraph_1_part_2)
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                append(intro_paragraph_2_part_1_normal)
                append("\n")
                withStyle(acerolaSpanStyle) {
                    append(intro_paragraph_2_part_2_acerola)
                }
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                append(intro_paragraph_3_part_1_normal)
                append("\n")
                withStyle(acerolaSpanStyle) {
                    append(intro_paragraph_3_part_2_acerola)
                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(intro_paragraph_3_part_3_acerola_bold)
                    }
                    append(intro_paragraph_3_part_4_acerola)
                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(intro_paragraph_3_part_5_acerola_bold)
                    }
                    append(intro_paragraph_3_part_6_acerola)
                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(intro_paragraph_3_part_7_acerola_bold)
                    }
                    append(intro_paragraph_3_part_8_acerola)
                }
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                withStyle(acerolaSpanStyle) {
                    append(intro_paragraph_4_part_1_acerola)
                }
                append("\n")
                append(intro_paragraph_4_part_2_normal)
                append("\n")
                withStyle(acerolaSpanStyle) {
                    append(intro_paragraph_4_part_3_acerola)
                }
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                withStyle(acerolaSpanStyle) {
                    append(intro_paragraph_5_part_1_acerola)
                }
                append("\n")
                append(intro_paragraph_5_part_2_normal)
            }
        }
    }

    TextFlow(
        text = text,
        modifier = modifier,
        placement = TextWrapPlacement.TopEnd,
        horizontalGap = 12.dp,
        verticalGap = 4.dp,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Color.White,
        ),
        component = {
            Image(
                painter = painterResource(Res.drawable.fervor_intro),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.22f)
                    .wrapContentHeight()
                    .shadowBorder()
                    .scale(scaleX = -1f, scaleY = 1f),
            )
        },
    )
}