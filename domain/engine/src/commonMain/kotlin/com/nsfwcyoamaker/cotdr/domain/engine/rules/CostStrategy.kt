package com.nsfwcyoamaker.cotdr.domain.engine.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState

sealed interface CostStrategy {
    fun calculateCost(state: ChoiceState, context: CalculationContext): Int
    fun validate(state: ChoiceState, context: CalculationContext): ChoiceState

    data class Simple(
        val cost: Int,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Int {
            calculationOverride?.let { return it.invoke(state, context) }
            return if (state.isSelected) cost else 0
        }
        override fun validate(state: ChoiceState, context: CalculationContext): ChoiceState = state
    }

    data class MultiBuy(
        val base: Int,
        val max: Int? = null,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Int {
            calculationOverride?.let { return it.invoke(state, context) }
            if (!state.isSelected) return 0
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
        val baseCost: Int,
        val upgradeCost: Int,
        val upgradeRequirements: (CalculationContext) -> Boolean = { true },
        val calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Int {
            calculationOverride?.let { return it.invoke(state, context) }
            if (!state.isSelected) return 0
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