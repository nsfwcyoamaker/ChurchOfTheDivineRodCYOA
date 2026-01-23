package com.nsfwcyoamaker.cotdr.domain.engine.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources

fun interface GlobalScoreRule {
    fun calculateScore(context: CalculationContext): Resources
}