package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy

enum class Priestess(
    override val strategy: CostStrategy? = null,
    override val requirements: (CalculationContext) -> Boolean = { true },
    override val upgradeRequirements: (CalculationContext) -> Boolean = { true },
): Choice {
    Acerola,
    Celeste,
    Desuri,
    Erina,
    Helena;
}