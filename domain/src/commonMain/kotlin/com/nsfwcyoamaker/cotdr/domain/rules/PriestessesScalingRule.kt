package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency
import com.nsfwcyoamaker.cotdr.domain.model.Priestess

object PriestessesScalingRule : GlobalScoreRule {
    override fun calculateScore(context: CalculationContext): Resources {
        val count = context.selections.keys.count { it is Priestess }

        if (count <= 1) return Resources.Empty

        val cost = (count * (count - 1)) / 2
        val total = cost * -1

        return Resources(CotdrCurrency.Fervor, total)
    }
}