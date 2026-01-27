package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalScoreRule
import com.nsfwcyoamaker.cotdr.domain.model.Brand
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency

object BrandsScalingRule: GlobalScoreRule {
    override fun calculateScore(context: CalculationContext): Resources {
        val count = context.selections.keys.count { it is Brand }
        if (count <= 3) return Resources.Empty //Womb is always free + 2 more, so 3 free
        return Resources(CotdrCurrency.Fervor, count * -1)
    }
}