package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.AlternativeChoice
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

enum class Contract: AlternativeChoice {
    FelicLusch,
    Barishi,
    Iustitia,
    Ithaca,
    Adoria,
    Harlan,
    Mieru,
    Estra,
    Boudica,
    KalimEter,
    Virgo,
    Murcielago,
    Sirococo,
    Vivianne;

    interface Alternative: AlternativeChoice.Alternative

    data class Servant(
        override val choice: Contract,
    ): Alternative {
        override val cost: Resources
            get() = Resources(Fervor, -2)
    }

    data class Familiar(
        override val choice: Contract,
    ): Alternative {
        override val cost: Resources
            get() = Resources(Fervor, -4)
    }

    override val alternatives: List<Alternative> = listOf(Servant(this), Familiar(this))
}