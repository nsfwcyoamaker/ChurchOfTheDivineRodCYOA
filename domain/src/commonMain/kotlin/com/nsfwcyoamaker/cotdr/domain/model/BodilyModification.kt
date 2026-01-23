package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy.*
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification.Tenfold

enum class BodilyModification(
    override val strategy: CostStrategy,
    override val requirements: (CalculationContext) -> Boolean = { true },
): Choice {
    BodyRemodeling(Simple(Resources(CotdrCurrency.Fervor, -2))),
    DualWield(MultiBuy(Resources(CotdrCurrency.Fervor, +8), calculationOverride = ::dualWieldCostOverride)),
    Zweihander(Simple(Resources(CotdrCurrency.Fervor, +3))),
    Miniature(Upgradable(Resources(CotdrCurrency.Fervor, -1), Resources(CotdrCurrency.Fervor, +3), upgradeRequirements = { ctx -> !ctx.hasUpgrade(Towering) })),
    Towering(Upgradable(Resources(CotdrCurrency.Fervor, -2), Resources(CotdrCurrency.Fervor, +2), upgradeRequirements = { ctx -> !ctx.hasUpgrade(Miniature) })),
    AmplifiedTouch(Simple(Resources(CotdrCurrency.Fervor, +2))),
    AllIn(Simple(Resources(CotdrCurrency.Fervor, +4))),
    Synchronized(Simple(Resources(CotdrCurrency.Fervor, +4))),
    MaximumLoad(MultiBuy(Resources(CotdrCurrency.Fervor, +2), max = 2)),
    Tenfold(MultiBuy(Resources(CotdrCurrency.Fervor, +2), max = 5)),
    SuperArmor(MultiBuy(Resources(CotdrCurrency.Fervor, -2), max = 2)),
    VastDepths(MultiBuy(Resources(CotdrCurrency.Fervor, +2), max = 5, calculationOverride = ::vastDepthsCostOverride)),
    RipAndTear(Simple(Resources(CotdrCurrency.Fervor, +3))),
    AmmoSwitcher(Simple(Resources(CotdrCurrency.Fervor, -3))),
    ComfortLayer(Simple(Resources(CotdrCurrency.Fervor, -1))),
    GroupDynamic(MultiBuy(Resources(CotdrCurrency.Fervor, +2), max = 2)),
    SustainedHeights(Simple(Resources(CotdrCurrency.Fervor, -3))),
    Rapunzel(Simple(Resources(CotdrCurrency.Fervor, +2)));

    val upgradeRequirements: (CalculationContext) -> Boolean
        get() = (strategy as? Upgradable)?.upgradeRequirements ?: { true }
}

private fun dualWieldCostOverride(
    state: ChoiceState,
    context: CalculationContext,
): Resources {
    if (!state.isSelected) return Resources.Empty
    val base = +8
    var total = 0
    var currentCost = base
    val count = state.quantity
    repeat(count) {
        total += currentCost
        currentCost /= 2
    }
    return Resources(CotdrCurrency.Fervor, total)
}

private fun vastDepthsCostOverride(
    state: ChoiceState,
    context: CalculationContext,
): Resources {
    if (!state.isSelected) return Resources.Empty
    val actualQ = state.quantity.coerceAtMost(5)
    val tenfoldAmount = context.quantityOf(Tenfold).coerceAtMost(5)

    val reducedAmount = tenfoldAmount.coerceAtMost(actualQ)
    val fullAmount = (actualQ - tenfoldAmount).coerceAtLeast(0)

    val total = (reducedAmount * (+1)) + (fullAmount * (+2))

    return Resources(CotdrCurrency.Fervor, total)
}