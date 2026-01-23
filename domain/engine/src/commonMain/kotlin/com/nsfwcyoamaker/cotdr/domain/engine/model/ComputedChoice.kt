package com.nsfwcyoamaker.cotdr.domain.engine.model

data class ComputedChoice(
    val choice: Choice,
    val state: ChoiceState,
    val isAvailable: Boolean,
    val cost: Resources,
    val maxQuantity: Int? = null,
    val isUpgradeAvailable: Boolean = false,
    val isUpgradeSelected: Boolean = false
)