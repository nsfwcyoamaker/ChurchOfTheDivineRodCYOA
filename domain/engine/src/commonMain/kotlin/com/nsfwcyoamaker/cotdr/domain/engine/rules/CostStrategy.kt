package com.nsfwcyoamaker.cotdr.domain.engine.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources

sealed interface CostStrategy {
    fun calculateCost(state: ChoiceState, context: CalculationContext): Resources
    fun validate(state: ChoiceState, context: CalculationContext): ChoiceState

    data class Simple(
        val cost: Resources,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Resources)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Resources {
            calculationOverride?.let { return it.invoke(state, context) }
            return if (state.isSelected) cost else Resources.Empty
        }
        override fun validate(state: ChoiceState, context: CalculationContext): ChoiceState = state
    }

    data class MultiBuy(
        val base: Resources,
        val max: Int? = null,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Resources)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Resources {
            calculationOverride?.let { return it.invoke(state, context) }
            if (!state.isSelected) return Resources.Empty

            val actualQ = if (max != null) state.quantity.coerceAtMost(max) else state.quantity
            return base * actualQ
        }
        override fun validate(state: ChoiceState, context: CalculationContext): ChoiceState {
            if (max != null && state.quantity > max) {
                return state.copy(quantity = max)
            }
            return state
        }
    }

    data class Upgradable(
        val baseCost: Resources,
        val upgradeCost: Resources,
        val upgradeRequirements: (CalculationContext) -> Boolean = { true },
        val calculationOverride: ((ChoiceState, CalculationContext) -> Resources)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Resources {
            calculationOverride?.let { return it.invoke(state, context) }
            if (!state.isSelected) return Resources.Empty
            return if (state.upgraded) upgradeCost else baseCost
        }
        override fun validate(state: ChoiceState, context: CalculationContext): ChoiceState {
            if (state.upgraded && !upgradeRequirements(context)) {
                return state.copy(upgraded = false)
            }
            return state
        }
    }
}