package com.nsfwcyoamaker.cotdr.domain.engine.model


interface Choice {
    fun getDefaultState(): ChoiceState
    fun getValidState(ctx: CalculationContext): ChoiceState?
    fun requirementsMet(ctx: CalculationContext): Boolean
    fun calculateCost(ctx: CalculationContext): Resources
    fun getComputedChoice(ctx: CalculationContext): ComputedChoice
}