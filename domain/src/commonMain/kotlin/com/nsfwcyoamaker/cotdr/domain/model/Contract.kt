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

    data object Servant: AlternativeChoice.Option {
        override val cost: Resources = Resources(Fervor, -2)
    }
    data object Follower: AlternativeChoice.Option {
        override val cost: Resources = Resources(Fervor, -4)
    }

    override val options = listOf(
        Servant,
        Follower,
    )
}