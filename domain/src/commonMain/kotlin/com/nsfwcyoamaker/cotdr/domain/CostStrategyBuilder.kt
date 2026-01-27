package com.nsfwcyoamaker.cotdr.domain

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy.*
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

object CostStrategyBuilder {
    fun simpleFervor(amount: Int): Simple = Simple(Resources(Fervor, amount))
    fun multiFervor(amount: Int, max: Int? = null, calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null): MultiBuy = MultiBuy(Resources(Fervor, amount), max, calculationOverride?.let { override -> { s, c -> Resources(Fervor, override(s,c)) } })
    fun upgradableFervor(base: Int, upgrade: Int, upgradeRequirements: (CalculationContext) -> Boolean = { true },): Upgradable = Upgradable(Resources(Fervor, base), Resources(Fervor, upgrade), upgradeRequirements)
}