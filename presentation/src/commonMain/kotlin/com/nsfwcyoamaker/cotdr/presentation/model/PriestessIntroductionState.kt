package com.nsfwcyoamaker.cotdr.presentation.model

data class PriestessIntroductionState(
    val priestessIntroductionOption: PriestessIntroductionOption,
    val isClickable: Boolean = true,
    val isSelected: Boolean = false,
)