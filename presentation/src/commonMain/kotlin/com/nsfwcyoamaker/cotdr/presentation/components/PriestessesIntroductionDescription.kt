package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_1_part_1_acerola
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_1_part_2_acerola_bold
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_1_part_3_acerola
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_1_acerola_bold
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_2_acerola
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_3_acerola_bold
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_4_acerola
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_5_acerola_bold
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_2_part_6_acerola
import com.nsfwcyoamaker.cotdr.resources.section_followers_description_paragraph_3_part_1_normal
import org.jetbrains.compose.resources.stringResource

@Composable
fun PriestessIntroductionDescription(
    modifier: Modifier = Modifier,
) {
    val section_followers_description_paragraph_1_part_1_acerola = stringResource(Res.string.section_followers_description_paragraph_1_part_1_acerola)
    val section_followers_description_paragraph_1_part_2_acerola_bold = stringResource(Res.string.section_followers_description_paragraph_1_part_2_acerola_bold)
    val section_followers_description_paragraph_1_part_3_acerola = stringResource(Res.string.section_followers_description_paragraph_1_part_3_acerola)
    val section_followers_description_paragraph_2_part_1_acerola_bold = stringResource(Res.string.section_followers_description_paragraph_2_part_1_acerola_bold)
    val section_followers_description_paragraph_2_part_2_acerola = stringResource(Res.string.section_followers_description_paragraph_2_part_2_acerola)
    val section_followers_description_paragraph_2_part_3_acerola_bold = stringResource(Res.string.section_followers_description_paragraph_2_part_3_acerola_bold)
    val section_followers_description_paragraph_2_part_4_acerola = stringResource(Res.string.section_followers_description_paragraph_2_part_4_acerola)
    val section_followers_description_paragraph_2_part_5_acerola_bold = stringResource(Res.string.section_followers_description_paragraph_2_part_5_acerola_bold)
    val section_followers_description_paragraph_2_part_6_acerola = stringResource(Res.string.section_followers_description_paragraph_2_part_6_acerola)
    val section_followers_description_paragraph_3_part_1_normal = stringResource(Res.string.section_followers_description_paragraph_3_part_1_normal)

    val acerolaSpanStyle = acerolaTextStyle.toSpanStyle()

    val sectionText = remember(
        section_followers_description_paragraph_1_part_1_acerola,
        section_followers_description_paragraph_1_part_2_acerola_bold,
        section_followers_description_paragraph_1_part_3_acerola,
        section_followers_description_paragraph_2_part_1_acerola_bold,
        section_followers_description_paragraph_2_part_2_acerola,
        section_followers_description_paragraph_2_part_3_acerola_bold,
        section_followers_description_paragraph_2_part_4_acerola,
        section_followers_description_paragraph_2_part_5_acerola_bold,
        section_followers_description_paragraph_2_part_6_acerola,
        section_followers_description_paragraph_3_part_1_normal,
    ) {
        buildAnnotatedString {
            withStyle(ParagraphStyle()) {
                withStyle(acerolaSpanStyle) {
                    append(section_followers_description_paragraph_1_part_1_acerola)
                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(section_followers_description_paragraph_1_part_2_acerola_bold)
                    }
                    append(section_followers_description_paragraph_1_part_3_acerola)
                }
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                withStyle(acerolaSpanStyle) {
                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(section_followers_description_paragraph_2_part_1_acerola_bold)
                    }
                    append(section_followers_description_paragraph_2_part_2_acerola)
                    append("\n")

                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(section_followers_description_paragraph_2_part_3_acerola_bold)
                    }
                    append(section_followers_description_paragraph_2_part_4_acerola)
                    append("\n")

                    withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                        append(section_followers_description_paragraph_2_part_5_acerola_bold)
                    }
                    append(section_followers_description_paragraph_2_part_6_acerola)
                }
            }



            append("\n")

            withStyle(ParagraphStyle()) {
                append(section_followers_description_paragraph_3_part_1_normal)
            }
        }
    }

    Text(
        text = sectionText,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Color.White,
        ),
        modifier = modifier,
    )
}