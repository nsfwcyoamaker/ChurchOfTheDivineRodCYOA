package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState

sealed interface CostStrategy {
    fun calculateCost(state: ChoiceState, context: CalculationContext): Int

    data class Simple(
        val cost: Int,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Int {
            calculationOverride?.let { return it.invoke(state, context) }
            return if (state.isSelected) cost else 0
        }
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
    }

    data class Upgradable(
        val baseCost: Int,
        val upgradeCost: Int,
        val calculationOverride: ((ChoiceState, CalculationContext) -> Int)? = null,
    ) : CostStrategy {
        override fun calculateCost(state: ChoiceState, context: CalculationContext): Int {
            calculationOverride?.let { return it.invoke(state, context) }
            if (!state.isSelected) return 0
            return if (state.upgraded) upgradeCost else baseCost
        }
    }
}