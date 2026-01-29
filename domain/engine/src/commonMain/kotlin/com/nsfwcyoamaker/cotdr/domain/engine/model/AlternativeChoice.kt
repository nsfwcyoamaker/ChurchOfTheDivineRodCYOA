package com.nsfwcyoamaker.cotdr.domain.engine.model


interface AlternativeChoice: Choice {
    interface Option {
        val cost: Resources
    }

    val options: List<Option>

    override fun getDefaultState(): ChoiceState.Alternative = ChoiceState.Alternative(options.first())
    override fun getValidState(ctx: CalculationContext): ChoiceState.Alternative? {
        return ctx.selections[this]
            ?.let { it as? ChoiceState.Alternative }
            ?.takeIf { requirementsMet(ctx) }
            ?.takeIf { it.selected in options }
    }
    override fun requirementsMet(ctx: CalculationContext): Boolean = true
    override fun calculateCost(ctx: CalculationContext): Resources {
        return getValidState(ctx)?.selected?.cost ?: Resources.Empty
    }
    override fun getComputedChoice(ctx: CalculationContext): ComputedChoice.Alternative {
        val state = getValidState(ctx)
        return ComputedChoice.Alternative(
            choice = this,
            state = state,
            isAvailable = requirementsMet(ctx),
            selected = state?.selected ?: options.first()
        )
    }
}