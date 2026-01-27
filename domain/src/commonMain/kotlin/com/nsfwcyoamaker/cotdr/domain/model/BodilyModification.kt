package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.*
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor

sealed interface BodilyModification: Choice {
    abstract class Simple(private val fervorCost: Int): BodilyModification, SimpleChoice {
        override val cost: Resources get() = Resources(Fervor, fervorCost)
    }
    abstract class Multi(private val fervorBase: Int, override val max: Int? = null): BodilyModification, MultibuyChoice {
        override val base: Resources get() = Resources(Fervor, fervorBase)
    }
    abstract class Upgradable(private val fervorBase: Int, private val fervorUpgrade: Int): BodilyModification, UpgradableChoice {
        override val baseCost: Resources get() = Resources(Fervor, fervorBase)
        override val upgradeCost: Resources get() = Resources(Fervor, fervorUpgrade)
    }

    data object BodyRemodeling: Simple(-2)
    data object DualWield: Multi(+8) {
        override fun calculateCost(ctx: CalculationContext): Resources {
            val state = getValidState(ctx) ?: return Resources.Empty

            val base = +8
            var total = 0
            var currentCost = base
            val count = state.quantity
            repeat(count) {
                total += currentCost
                currentCost /= 2
            }

            return Resources(Fervor, total)
        }
    }
    data object Zweihander: Simple(+3)
    data object Miniature: Upgradable(-1, +3) {
        override fun upgradeRequirementsMet(ctx: CalculationContext): Boolean {
            return Towering.getValidState(ctx)?.upgraded?.not() ?: return true
        }
    }
    data object Towering: Upgradable(-2, +2) {
        override fun upgradeRequirementsMet(ctx: CalculationContext): Boolean {
            return Miniature.getValidState(ctx)?.upgraded?.not() ?: return true
        }
    }
    data object AmplifiedTouch: Simple(+2)
    data object AllIn: Simple(+4)
    data object Synchronized: Simple(+4)
    data object MaximumLoad: Multi(+2, max = 2)
    data object Tenfold: Multi(+2, max = 5)
    data object SuperArmor: Multi(-2, max = 2)
    data object VastDepths: Multi(+2, max = 5) {
        override fun calculateCost(ctx: CalculationContext): Resources {
            val state = getValidState(ctx) ?: return Resources.Empty

            val actualQ = state.quantity.coerceAtMost(5)
            val tenfoldAmount = Tenfold.getValidState(ctx)?.quantity?.coerceAtMost(5) ?: 0

            val reducedAmount = tenfoldAmount.coerceAtMost(actualQ)
            val fullAmount = (actualQ - tenfoldAmount).coerceAtLeast(0)

            val total = (reducedAmount * (+1)) + (fullAmount * (+2))

            return Resources(Fervor, total)
        }
    }
    data object RipAndTear: Simple(+3)
    data object AmmoSwitcher: Simple(-3)
    data object ComfortLayer: Simple(-1)
    data object GroupDynamic: Multi(+2, max = 2)
    data object SustainedHeights: Simple(-3)
    data object Rapunzel: Simple(+2)


    companion object {
        val all: List<BodilyModification>
            get() = listOf(
                BodyRemodeling,
                DualWield,
                Zweihander,
                Miniature,
                Towering,
                AmplifiedTouch,
                AllIn,
                Synchronized,
                MaximumLoad,
                Tenfold,
                SuperArmor,
                VastDepths,
                RipAndTear,
                AmmoSwitcher,
                ComfortLayer,
                GroupDynamic,
                SustainedHeights,
                Rapunzel,
            )
    }
}