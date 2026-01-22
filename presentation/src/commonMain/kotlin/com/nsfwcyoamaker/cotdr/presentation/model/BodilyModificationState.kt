package com.nsfwcyoamaker.cotdr.presentation.model

data class BodilyModificationState(
    val bodilyModificationOption: BodilyModificationOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
    val fervorContribution: Int = 0,
)