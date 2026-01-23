package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy

enum class Priestess: Choice {
    Acerola,
    Celeste,
    Desuri,
    Erina,
    Helena;

    override val strategy: CostStrategy = CostStrategy.Simple(0)
    override val requirements: (CalculationContext) -> Boolean = { true }
}