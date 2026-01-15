package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.nsfwcyoamaker.cotdr.presentation.components.FollowerIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroduction
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.mainTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun MainScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            contentDescription = null,
            painter = painterResource(Res.drawable.cathedral_02_preprocessed),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                Text(
                    text = stringResource(Res.string.title),
                    style = mainTitleTextStyle,
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
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

                val introText = remember(
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
                    introText,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
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
                            painter = painterResource(Res.drawable.intro_priestess),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(360.dp)
                                .wrapContentHeight()
                                .shadowBorder(),
                        )
                    },
                )
            }

            item {
                SectionTitle(
                    title = stringResource(Res.string.section_followers_title),
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item {
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
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item {
                val priestessesByRow = remember { PriestessIntroduction.entries.chunked(3) }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                ) {
                    priestessesByRow.forEach { priestessesRow ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                        ) {
                            priestessesRow.forEach { priestess ->
                                FollowerIntroduction(
                                    title = priestess.getTitleText(),
                                    titleStyle = priestess.getTitleStyle(),
                                    image = priestess.image,
                                    description = priestess.getDescription(),
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight(),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}