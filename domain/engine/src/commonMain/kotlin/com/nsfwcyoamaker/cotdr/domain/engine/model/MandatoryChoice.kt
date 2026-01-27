package com.nsfwcyoamaker.cotdr.domain.engine.model

interface MandatoryChoice: SimpleChoice {
    override fun getValidState(ctx: CalculationContext): ChoiceState.Selected? {
        return if (requirementsMet(ctx)) ChoiceState.Selected else null
    }
}