package com.nsfwcyoamaker.cotdr.presentation.model

data class CovenantState(
    val option: CovenantOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
)