package com.nsfwcyoamaker.cotdr.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.acerolaTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.celesteTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.desuriTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.erinaTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.genericPriestessTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.helenaTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_acerola
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_celeste
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_consorts
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_desuri
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_erina
import com.nsfwcyoamaker.cotdr.resources.priestess_introduction_helena
import com.nsfwcyoamaker.cotdr.resources.section_followers_acerola_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_celeste_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_consorts_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_desuri_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_erina_title
import com.nsfwcyoamaker.cotdr.resources.section_followers_helena_title
import org.jetbrains.compose.resources.DrawableResource
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
        { AnnotatedString("") }, //todo
    ),
    Celeste(
        { stringResource(Res.string.section_followers_celeste_title) },
        { celesteTitleTextStyle },
        Res.drawable.priestess_introduction_celeste,
        { AnnotatedString("") }, //todo
    ),
    Desuri(
        { stringResource(Res.string.section_followers_desuri_title) },
        { desuriTitleTextStyle },
        Res.drawable.priestess_introduction_desuri,
        { AnnotatedString("") }, //todo
    ),
    Erina(
        { stringResource(Res.string.section_followers_erina_title) },
        { erinaTitleTextStyle },
        Res.drawable.priestess_introduction_erina,
        { AnnotatedString("") }, //todo
    ),
    Helena(
        { stringResource(Res.string.section_followers_helena_title) },
        { helenaTitleTextStyle },
        Res.drawable.priestess_introduction_helena,
        { AnnotatedString("") }, //todo
    ),
    Consorts(
        { stringResource(Res.string.section_followers_consorts_title) },
        { genericPriestessTitleTextStyle },
        Res.drawable.priestess_introduction_consorts,
        { AnnotatedString("") }, //todo
    );
}