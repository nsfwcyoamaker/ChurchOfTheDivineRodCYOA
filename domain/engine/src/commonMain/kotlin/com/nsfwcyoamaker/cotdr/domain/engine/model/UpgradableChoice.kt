package com.nsfwcyoamaker.cotdr.domain.engine.model


interface UpgradableChoice: Choice {
    val baseCost: Resources
    val upgradeCost: Resources

    override fun getDefaultState(): ChoiceState.Upgradable = ChoiceState.Upgradable()
    override fun getValidState(ctx: CalculationContext): ChoiceState.Upgradable? {
        return ctx.selections[this]
            ?.let { it as? ChoiceState.Upgradable }
            ?.takeIf { requirementsMet(ctx) }
            ?.let { it.copy(upgraded = it.upgraded && upgradeRequirementsMet(ctx)) }
    }
    override fun requirementsMet(ctx: CalculationContext): Boolean = true
    override fun calculateCost(ctx: CalculationContext): Resources {
        return getValidState(ctx)
            ?.let { if(it.upgraded) upgradeCost else baseCost }
            ?: return Resources.Empty
    }
    override fun getComputedChoice(ctx: CalculationContext): ComputedChoice.Upgradable {
        val state = getValidState(ctx)
        return ComputedChoice.Upgradable(
            choice = this,
            state = state,
            isAvailable = requirementsMet(ctx),
            isUpgradeAvailable = upgradeRequirementsMet(ctx),
            isUpgradeSelected = state?.upgraded ?: false,
        )
    }

    fun upgradeRequirementsMet(ctx: CalculationContext): Boolean = true
}