package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification.Tenfold
import com.nsfwcyoamaker.cotdr.domain.CostStrategyBuilder.multiFervor as multi
import com.nsfwcyoamaker.cotdr.domain.CostStrategyBuilder.simpleFervor as simple
import com.nsfwcyoamaker.cotdr.domain.CostStrategyBuilder.upgradableFervor as upgradable

enum class BodilyModification(
    override val strategy: CostStrategy,
    override val requirements: (CalculationContext) -> Boolean = { true },
): Choice {
    BodyRemodeling(simple(-2)),
    DualWield(multi(+8, calculationOverride = ::dualWieldCostOverride)),
    Zweihander(simple(+3)),
    Miniature(upgradable(-1, +3, upgradeRequirements = { ctx -> !ctx.hasUpgrade(Towering) })),
    Towering(upgradable(-2, +2, upgradeRequirements = { ctx -> !ctx.hasUpgrade(Miniature) })),
    AmplifiedTouch(simple(+2)),
    AllIn(simple(+4)),
    Synchronized(simple(+4)),
    MaximumLoad(multi(+2, max = 2)),
    Tenfold(multi(+2, max = 5)),
    SuperArmor(multi(-2, max = 2)),
    VastDepths(multi(+2, max = 5, calculationOverride = ::vastDepthsCostOverride)),
    RipAndTear(simple(+3)),
    AmmoSwitcher(simple(-3)),
    ComfortLayer(simple(-1)),
    GroupDynamic(multi(+2, max = 2)),
    SustainedHeights(simple(-3)),
    Rapunzel(simple(+2));
}

private fun dualWieldCostOverride(
    state: ChoiceState,
    context: CalculationContext,
): Int {
    if (!state.isSelected) return 0
    val base = +8
    var total = 0
    var currentCost = base
    val count = state.quantity
    repeat(count) {
        total += currentCost
        currentCost /= 2
    }
    return total
}

private fun vastDepthsCostOverride(
    state: ChoiceState,
    context: CalculationContext,
): Int {
    if (!state.isSelected) return 0
    val actualQ = state.quantity.coerceAtMost(5)
    val tenfoldAmount = context.quantityOf(Tenfold).coerceAtMost(5)

    val reducedAmount = tenfoldAmount.coerceAtMost(actualQ)
    val fullAmount = (actualQ - tenfoldAmount).coerceAtLeast(0)

    val total = (reducedAmount * (+1)) + (fullAmount * (+2))

    return total
}