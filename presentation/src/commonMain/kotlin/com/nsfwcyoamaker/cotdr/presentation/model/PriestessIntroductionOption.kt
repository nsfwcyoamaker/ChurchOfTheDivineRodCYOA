package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class PriestessIntroductionOption(
    override val choice: Priestess,
    val ui: Ui,
): UiOption {
    Acerola(
        Priestess.Acerola,
        Ui(
            Res.string.priestess_introduction_acerola_title,
            Res.drawable.priestess_introduction_acerola,
            Res.string.priestess_introduction_acerola,
        )
    ),
    Celeste(
        Priestess.Celeste,
        Ui(
            Res.string.priestess_introduction_celeste_title,
            Res.drawable.priestess_introduction_celeste,
            Res.string.priestess_introduction_celeste,
        )
    ),
    Desuri(
        Priestess.Desuri,
        Ui(
            Res.string.priestess_introduction_desuri_title,
            Res.drawable.priestess_introduction_desuri,
            Res.string.priestess_introduction_desuri,
        )
    ),
    Erina(
        Priestess.Erina,
        Ui(
            Res.string.priestess_introduction_erina_title,
            Res.drawable.priestess_introduction_erina,
            Res.string.priestess_introduction_erina,
        )
    ),
    Helena(
        Priestess.Helena,
        Ui(
            Res.string.priestess_introduction_helena_title,
            Res.drawable.priestess_introduction_helena,
            Res.string.priestess_introduction_helena,
        )
    );

    data class Ui(
        val title: StringResource,
        val image: DrawableResource,
        val description: StringResource,
    )

    companion object {
        val consortsUi = Ui(
            Res.string.priestess_introduction_consorts_title,
            Res.drawable.priestess_introduction_consorts,
            Res.string.priestess_introduction_consorts,
        )
    }
}