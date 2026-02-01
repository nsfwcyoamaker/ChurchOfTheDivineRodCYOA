package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.model.SimpleChoice
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

enum class ChurchAppeal: SimpleChoice {
    HardNo,
    LiveAndLetLive,
    WellMaybe;

    override val cost: Resources
        get() = Resources(Fervor, 0)
}