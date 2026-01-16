package com.nsfwcyoamaker.cotdr.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.em
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.celesteTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.celesteTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.desuriTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.desuriTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.erinaTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.erinaTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.genericPriestessTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.helenaTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.helenaTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_acerola
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_acerola_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_acerola_self
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_celeste
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_celeste_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_celeste_self
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_10_normal_bold
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_11_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_1_acerola
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_2_acerola_bold
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_3_acerola
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_4_acerola_smaller_1
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_5_acerola_smaller_2
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_6_acerola_smaller_3
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_7_acerola_smaller_4
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_8_acerola_smaller_5
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts_part_9_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_desuri
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_desuri_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_desuri_self
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_erina
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_erina_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_erina_self
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_helena
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_helena_normal
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_helena_self
import com.nsfwcyoamaker.cotdr.resources.section_followers_acerola_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_celeste_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_consorts_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_desuri_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_erina_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_helena_title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

enum class PriestessIntroduction(
    val getTitleText: @Composable () -> String,
    val getTitleStyle: @Composable () -> TextStyle,
    val image: DrawableResource,
    val getDescription: @Composable () -> AnnotatedString,
) {
    Acerola(
        { stringResource(Res.string.section_followers_acerola_title) },
        { acerolaTitleTextStyle },
        Res.drawable.priestess_introduction_acerola,
        {
            buildDescription(
                normalText = Res.string.priestess_introduction_acerola_normal,
                selfText = Res.string.priestess_introduction_acerola_self,
                selfStyle = acerolaTextStyle,
            )
        },
    ),
    Celeste(
        { stringResource(Res.string.section_followers_celeste_title) },
        { celesteTitleTextStyle },
        Res.drawable.priestess_introduction_celeste,
        {
            buildDescription(
                normalText = Res.string.priestess_introduction_celeste_normal,
                selfText = Res.string.priestess_introduction_celeste_self,
                selfStyle = celesteTextStyle,
            )
        },
    ),
    Desuri(
        { stringResource(Res.string.section_followers_desuri_title) },
        { desuriTitleTextStyle },
        Res.drawable.priestess_introduction_desuri,
        {
            buildDescription(
                normalText = Res.string.priestess_introduction_desuri_normal,
                selfText = Res.string.priestess_introduction_desuri_self,
                selfStyle = desuriTextStyle,
            )
        },
    ),
    Erina(
        { stringResource(Res.string.section_followers_erina_title) },
        { erinaTitleTextStyle },
        Res.drawable.priestess_introduction_erina,
        {
            buildDescription(
                normalText = Res.string.priestess_introduction_erina_normal,
                selfText = Res.string.priestess_introduction_erina_self,
                selfStyle = erinaTextStyle,
            )
        },
    ),
    Helena(
        { stringResource(Res.string.section_followers_helena_title) },
        { helenaTitleTextStyle },
        Res.drawable.priestess_introduction_helena,
        {
            buildDescription(
                normalText = Res.string.priestess_introduction_helena_normal,
                selfText = Res.string.priestess_introduction_helena_self,
                selfStyle = helenaTextStyle,
            )
        },
    ),
    Consorts(
        { stringResource(Res.string.section_followers_consorts_title) },
        { genericPriestessTitleTextStyle },
        Res.drawable.priestess_introduction_consorts,
        {
            val priestess_introduction_consorts_part_1_acerola = stringResource(Res.string.priestess_introduction_consorts_part_1_acerola)
            val priestess_introduction_consorts_part_2_acerola_bold = stringResource(Res.string.priestess_introduction_consorts_part_2_acerola_bold)
            val priestess_introduction_consorts_part_3_acerola = stringResource(Res.string.priestess_introduction_consorts_part_3_acerola)
            val priestess_introduction_consorts_part_4_acerola_smaller_1 = stringResource(Res.string.priestess_introduction_consorts_part_4_acerola_smaller_1)
            val priestess_introduction_consorts_part_5_acerola_smaller_2 = stringResource(Res.string.priestess_introduction_consorts_part_5_acerola_smaller_2)
            val priestess_introduction_consorts_part_6_acerola_smaller_3 = stringResource(Res.string.priestess_introduction_consorts_part_6_acerola_smaller_3)
            val priestess_introduction_consorts_part_7_acerola_smaller_4 = stringResource(Res.string.priestess_introduction_consorts_part_7_acerola_smaller_4)
            val priestess_introduction_consorts_part_8_acerola_smaller_5 = stringResource(Res.string.priestess_introduction_consorts_part_8_acerola_smaller_5)

            val priestess_introduction_consorts_part_9_normal = stringResource(Res.string.priestess_introduction_consorts_part_9_normal)
            val priestess_introduction_consorts_part_10_normal_bold = stringResource(Res.string.priestess_introduction_consorts_part_10_normal_bold)
            val priestess_introduction_consorts_part_11_normal = stringResource(Res.string.priestess_introduction_consorts_part_11_normal)

            val acerolaSpanStyle = acerolaTextStyle.toSpanStyle()

            remember(
                priestess_introduction_consorts_part_1_acerola,
                priestess_introduction_consorts_part_2_acerola_bold,
                priestess_introduction_consorts_part_3_acerola,
                priestess_introduction_consorts_part_4_acerola_smaller_1,
                priestess_introduction_consorts_part_5_acerola_smaller_2,
                priestess_introduction_consorts_part_6_acerola_smaller_3,
                priestess_introduction_consorts_part_7_acerola_smaller_4,
                priestess_introduction_consorts_part_8_acerola_smaller_5,
                priestess_introduction_consorts_part_9_normal,
                priestess_introduction_consorts_part_10_normal_bold,
                priestess_introduction_consorts_part_11_normal,
            ) {
                buildAnnotatedString {
                    withStyle(ParagraphStyle()) {
                        withStyle(acerolaSpanStyle) {
                            append(priestess_introduction_consorts_part_1_acerola)
                            withStyle(SpanStyle(fontSize = (1.1).em, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)) {
                                append(priestess_introduction_consorts_part_2_acerola_bold)
                            }
                            append(priestess_introduction_consorts_part_3_acerola)
                            withStyle(SpanStyle(fontSize = (0.9).em)) {
                                append(priestess_introduction_consorts_part_4_acerola_smaller_1)
                            }
                            withStyle(SpanStyle(fontSize = (0.8).em)) {
                                append(priestess_introduction_consorts_part_5_acerola_smaller_2)
                            }
                            withStyle(SpanStyle(fontSize = (0.7).em)) {
                                append(priestess_introduction_consorts_part_6_acerola_smaller_3)
                            }
                            withStyle(SpanStyle(fontSize = (0.6).em)) {
                                append(priestess_introduction_consorts_part_7_acerola_smaller_4)
                            }
                            withStyle(SpanStyle(fontSize = (0.5).em)) {
                                append(priestess_introduction_consorts_part_8_acerola_smaller_5)
                            }
                        }
                    }

                    append("\n")

                    withStyle(ParagraphStyle()) {
                        append(priestess_introduction_consorts_part_9_normal)
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(priestess_introduction_consorts_part_10_normal_bold)
                        }
                        append(priestess_introduction_consorts_part_11_normal)
                    }
                }
            }
        },
    );

    companion object {
        @Composable
        private fun buildDescription(
            normalText: StringResource,
            selfText: StringResource,
            selfStyle: TextStyle,
        ): AnnotatedString {
            val normal = stringResource(normalText)
            val self = stringResource(selfText)
            val selfSpanStyle = selfStyle.toSpanStyle()

            return remember(self, normal) {
                buildAnnotatedString {
                    withStyle(ParagraphStyle()) {
                        withStyle(selfSpanStyle) {
                            append(self)
                        }
                    }

                    append("\n")

                    withStyle(ParagraphStyle()) {
                        append(normal)
                    }
                }
            }
        }
    }
}