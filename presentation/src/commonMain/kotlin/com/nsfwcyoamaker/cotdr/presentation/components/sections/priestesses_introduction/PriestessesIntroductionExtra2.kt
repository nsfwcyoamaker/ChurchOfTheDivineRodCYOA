package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.stringResource

@Composable
fun PriestessIntroductionExtra2(
    modifier: Modifier = Modifier,
) {
    val priestess_introduction_extra_2_paragraph_1_normal = stringResource(Res.string.priestess_introduction_extra_2_paragraph_1_normal)
    val priestess_introduction_extra_2_paragraph_2_part_1_acerola = stringResource(Res.string.priestess_introduction_extra_2_paragraph_2_part_1_acerola)
    val priestess_introduction_extra_2_paragraph_2_part_2_acerola_small = stringResource(Res.string.priestess_introduction_extra_2_paragraph_2_part_2_acerola_small)
    val priestess_introduction_extra_2_paragraph_2_part_3_acerola = stringResource(Res.string.priestess_introduction_extra_2_paragraph_2_part_3_acerola)

    val acerolaSpanStyle = acerolaTextStyle.toSpanStyle()

    val sectionText = remember(
        priestess_introduction_extra_2_paragraph_1_normal,
        priestess_introduction_extra_2_paragraph_2_part_1_acerola,
        priestess_introduction_extra_2_paragraph_2_part_2_acerola_small,
        priestess_introduction_extra_2_paragraph_2_part_3_acerola,
    ) {
        buildAnnotatedString {
            withStyle(ParagraphStyle()) {
                append(priestess_introduction_extra_2_paragraph_1_normal)
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                withStyle(acerolaSpanStyle) {
                    append(priestess_introduction_extra_2_paragraph_2_part_1_acerola)
                    withStyle(SpanStyle(fontSize = (0.8).em)) {
                        append(priestess_introduction_extra_2_paragraph_2_part_2_acerola_small)
                    }
                    append(priestess_introduction_extra_2_paragraph_2_part_3_acerola)
                }
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