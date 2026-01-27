package com.nsfwcyoamaker.cotdr.domain.engine.model


interface SimpleChoice: Choice {
    val cost: Resources

    override fun getDefaultState(): ChoiceState.Selected = ChoiceState.Selected
    override fun getValidState(ctx: CalculationContext): ChoiceState.Selected? {
        return ctx.selections[this]
            ?.let { it as? ChoiceState.Selected }
            ?.takeIf { requirementsMet(ctx) }
    }
    override fun requirementsMet(ctx: CalculationContext): Boolean = true
    override fun calculateCost(ctx: CalculationContext): Resources {
        val state = getValidState(ctx)
        return if (state != null) cost else Resources.Empty
    }
    override fun getComputedChoice(ctx: CalculationContext): ComputedChoice.Simple {
        return ComputedChoice.Simple(
            choice = this,
            state = getValidState(ctx),
            isAvailable = requirementsMet(ctx),
        )
    }
}