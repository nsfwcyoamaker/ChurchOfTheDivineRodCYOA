package com.nsfwcyoamaker.cotdr.domain.engine.model

class CalculationContext(
    val selections: Map<Choice, ChoiceState>
) {
    fun has(mod: Choice): Boolean {
        return selections[mod]?.isSelected == true
    }

    fun hasUpgrade(mod: Choice): Boolean {
        val state = selections[mod]
        return state?.isSelected == true && state.upgraded
    }

    fun quantityOf(mod: Choice): Int {
        return selections[mod]?.quantity ?: 0
    }
}