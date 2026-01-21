package com.nsfwcyoamaker.cotdr.presentation.model

data class BodilyModificationState(
    val bodilyModificationOption: BodilyModificationOption,
    val isSelected: Boolean = false,
    val fervorChange: Int = 0,
    val boughtTimes: Int = 0,
    val empoweredEnabled: Boolean = false,
    val empoweredSelected: Boolean = false,
)