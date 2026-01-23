package com.nsfwcyoamaker.cotdr.domain.engine.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext

fun interface GlobalScoreRule {
    fun calculateScore(context: CalculationContext): Int
}