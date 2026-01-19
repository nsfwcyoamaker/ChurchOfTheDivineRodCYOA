package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.stringResource

@Composable
fun PriestessIntroductionExtra(
    modifier: Modifier = Modifier,
) {
    val priestess_introduction_extra_paragraph_1_part_1_normal = stringResource(Res.string.priestess_introduction_extra_paragraph_1_part_1_normal)
    val priestess_introduction_extra_paragraph_1_part_2_acerola = stringResource(Res.string.priestess_introduction_extra_paragraph_1_part_2_acerola)
    val priestess_introduction_extra_paragraph_2_part_1_normal = stringResource(Res.string.priestess_introduction_extra_paragraph_2_part_1_normal)

    val acerolaSpanStyle = acerolaTextStyle.toSpanStyle()

    val sectionText = remember(
        priestess_introduction_extra_paragraph_1_part_1_normal,
        priestess_introduction_extra_paragraph_1_part_2_acerola,
        priestess_introduction_extra_paragraph_2_part_1_normal,
    ) {
        buildAnnotatedString {
            withStyle(ParagraphStyle()) {
                append(priestess_introduction_extra_paragraph_1_part_1_normal)
                append("\n")
                withStyle(acerolaSpanStyle) {
                    append(priestess_introduction_extra_paragraph_1_part_2_acerola)
                }
            }

            append("\n")

            withStyle(ParagraphStyle()) {
                append(priestess_introduction_extra_paragraph_2_part_1_normal)
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