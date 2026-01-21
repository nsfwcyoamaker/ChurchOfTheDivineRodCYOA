package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy

interface Choice {
    val strategy: CostStrategy?
    val requirements: (CalculationContext) -> Boolean
    val upgradeRequirements: (CalculationContext) -> Boolean
}