package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification.Tenfold
import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy
import com.nsfwcyoamaker.cotdr.domain.rules.CostStrategy.*

enum class BodilyModification(
    override val strategy: CostStrategy,
    override val requirements: (CalculationContext) -> Boolean = { true },
    override val upgradeRequirements: (CalculationContext) -> Boolean = { true }
): Choice {
    BodyRemodeling(Simple(-2)),
    DualWield(MultiBuy(+8, calculationOverride = ::dualWieldCostOverride)),
    Zweihander(Simple(+3)),
    Miniature(
        strategy = Upgradable(-2, +3),
        upgradeRequirements = { ctx -> !ctx.hasUpgrade(Towering) }
    ),
    Towering(
        strategy = Upgradable(-2, +2),
        upgradeRequirements = { ctx -> !ctx.hasUpgrade(Miniature) }
    ),
    AmplifiedTouch(Simple(+2)),
    AllIn(Simple(+4)),
    Synchronized(Simple(+4)),
    MaximumLoad(MultiBuy(+2, max = 2)),
    Tenfold(MultiBuy(+2, max = 5)),
    SuperArmor(MultiBuy(-2, max = 2)),
    VastDepths(MultiBuy(+2, max = 5, calculationOverride = ::vastDepthsCostOverride)),
    RipAndTear(Simple(+3)),
    AmmoSwitcher(Simple(-3)),
    ComfortLayer(Simple(-1)),
    GroupDynamic(MultiBuy(+2, max = 2)),
    SustainedHeights(Simple(-3)),
    Rapunzel(Simple(+2));
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

    return (reducedAmount * (+1)) + (fullAmount * (+2))
}