package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy
import com.nsfwcyoamaker.cotdr.domain.CostStrategyBuilder.simpleFervor as simple

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

    override val strategy: CostStrategy = simple(+4)
    override val requirements: (CalculationContext) -> Boolean = { true }
}