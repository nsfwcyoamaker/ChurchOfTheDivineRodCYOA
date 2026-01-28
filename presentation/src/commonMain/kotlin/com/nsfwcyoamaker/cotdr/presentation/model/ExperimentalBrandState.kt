package com.nsfwcyoamaker.cotdr.presentation.model

data class ExperimentalBrandState(
    val option: ExperimentalBrandOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
)