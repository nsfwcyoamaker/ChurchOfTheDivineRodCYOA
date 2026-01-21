package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class PriestessIntroductionOption(
    val priestess: Priestess?,
    val title: StringResource,
    val image: DrawableResource,
    val description: StringResource,
) {
    Acerola(
        Priestess.Acerola,
        Res.string.priestess_introduction_acerola_title,
        Res.drawable.priestess_introduction_acerola,
        Res.string.priestess_introduction_acerola
    ),
    Celeste(
        Priestess.Celeste,
        Res.string.priestess_introduction_celeste_title,
        Res.drawable.priestess_introduction_celeste,
        Res.string.priestess_introduction_celeste,
    ),
    Desuri(
        Priestess.Desuri,
        Res.string.priestess_introduction_desuri_title,
        Res.drawable.priestess_introduction_desuri,
        Res.string.priestess_introduction_desuri,
    ),
    Erina(
        Priestess.Erina,
        Res.string.priestess_introduction_erina_title,
        Res.drawable.priestess_introduction_erina,
        Res.string.priestess_introduction_erina,
    ),
    Helena(
        Priestess.Helena,
        Res.string.priestess_introduction_helena_title,
        Res.drawable.priestess_introduction_helena,
        Res.string.priestess_introduction_helena
    ),
    Consorts(
        null,
        Res.string.priestess_introduction_consorts_title,
        Res.drawable.priestess_introduction_consorts,
        Res.string.priestess_introduction_consorts,
    );
}