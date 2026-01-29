package com.nsfwcyoamaker.cotdr.domain.engine.model


interface MultibuyChoice: Choice {
    val base: Resources
    val max: Int?

    override fun getDefaultState(): ChoiceState.MultiBuy = ChoiceState.MultiBuy()
    override fun getValidState(ctx: CalculationContext): ChoiceState.MultiBuy? {
        return ctx.selections[this]
            ?.let { it as? ChoiceState.MultiBuy }
            ?.takeIf { requirementsMet(ctx) }
            ?.takeIf { it.quantity > 0 } // if quantity < 0 then it's not selected, we remove the state
            ?.let { state -> max?.let { state.copy(quantity = state.quantity.coerceAtMost(it)) } ?: state }
    }
    override fun requirementsMet(ctx: CalculationContext): Boolean = true
    override fun calculateCost(ctx: CalculationContext): Resources {
        return getValidState(ctx)
            ?.let { base * it.quantity }
            ?: return Resources.Empty
    }
    override fun getComputedChoice(ctx: CalculationContext): ComputedChoice.MultiBuy {
        val state = getValidState(ctx)
        return ComputedChoice.MultiBuy(
            choice = this,
            state = state,
            isAvailable = requirementsMet(ctx),
            quantity = state?.quantity ?: 0,
            maxQuantity = max,
            canBuyMore = max?.let { (state?.quantity ?: 0) < it } ?: true,
            totalCost = calculateCost(ctx),
        )
    }
}