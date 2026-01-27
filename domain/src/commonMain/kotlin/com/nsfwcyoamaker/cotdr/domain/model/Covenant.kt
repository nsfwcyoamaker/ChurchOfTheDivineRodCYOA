package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.model.SimpleChoice
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

enum class Covenant: SimpleChoice {
    TheHorn,
    TheInn,
    TheFeast,
    TheSpectrum,
    Inversion,
    Kin,
    TheForge,
    TheChalice,
    Purification,
    TheBlossom,
    TheFountain,
    Welcome,
    TheCaress,
    Breath,
    ThePearl,
    Bindings,
    ThePromise,
    TheTamer;

    override val cost: Resources get() = Resources(Fervor, +4)
}