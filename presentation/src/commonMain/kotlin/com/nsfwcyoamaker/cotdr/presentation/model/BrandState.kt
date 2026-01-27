package com.nsfwcyoamaker.cotdr.presentation.model

data class BrandState(
    val option: BrandOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
)