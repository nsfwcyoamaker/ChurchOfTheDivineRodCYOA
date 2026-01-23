package com.nsfwcyoamaker.cotdr.domain.engine.model

import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy


interface Choice {
    val strategy: CostStrategy
    val requirements: (CalculationContext) -> Boolean
}