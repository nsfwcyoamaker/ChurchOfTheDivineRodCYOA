package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.model.SimpleChoice
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

enum class ExperimentalBrand: SimpleChoice {
    Pupil,
    Egg,
    Hair,
    Pussy,
    Piercings,
    Minimal,
    Light,
    Talisman,
    Marking;

    override val cost: Resources get() = Resources(Fervor, -2)
}