package com.nsfwcyoamaker.cotdr.domain.engine.model

data class CalculationContext(
    val selections: Map<Choice, ChoiceState>
)