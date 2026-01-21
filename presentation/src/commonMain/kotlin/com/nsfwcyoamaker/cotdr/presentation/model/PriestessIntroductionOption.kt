package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class PriestessIntroductionOption(
    val title: StringResource,
    val image: DrawableResource,
    val description: StringResource,
) {
    Acerola(
        Res.string.priestess_introduction_acerola_title,
        Res.drawable.priestess_introduction_acerola,
        Res.string.priestess_introduction_acerola
    ),
    Celeste(
        Res.string.priestess_introduction_celeste_title,
        Res.drawable.priestess_introduction_celeste,
        Res.string.priestess_introduction_celeste,
    ),
    Desuri(
        Res.string.priestess_introduction_desuri_title,
        Res.drawable.priestess_introduction_desuri,
        Res.string.priestess_introduction_desuri,
    ),
    Erina(
        Res.string.priestess_introduction_erina_title,
        Res.drawable.priestess_introduction_erina,
        Res.string.priestess_introduction_erina,
    ),
    Helena(
        Res.string.priestess_introduction_helena_title,
        Res.drawable.priestess_introduction_helena,
        Res.string.priestess_introduction_helena
    ),
    Consorts(
        Res.string.priestess_introduction_consorts_title,
        Res.drawable.priestess_introduction_consorts,
        Res.string.priestess_introduction_consorts,
    );
}