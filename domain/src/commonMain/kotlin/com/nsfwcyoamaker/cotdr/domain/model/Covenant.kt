package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy

enum class Covenant: Choice {
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

    override val strategy: CostStrategy = CostStrategy.Simple(Resources(CotdrCurrency.Fervor, +4))
    override val requirements: (CalculationContext) -> Boolean = { true }
}