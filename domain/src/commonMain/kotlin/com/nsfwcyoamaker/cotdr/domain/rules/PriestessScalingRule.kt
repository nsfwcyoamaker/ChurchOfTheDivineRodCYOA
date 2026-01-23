package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule
import com.nsfwcyoamaker.cotdr.domain.model.Priestess

object PriestessScalingRule : GlobalScoreRule {
    override fun calculateScore(context: CalculationContext): Int {
        val count = context.selections.keys.count { it is Priestess }

        if (count <= 1) return 0

        val cost = (count * (count - 1)) / 2
        return cost * -1
    }
}