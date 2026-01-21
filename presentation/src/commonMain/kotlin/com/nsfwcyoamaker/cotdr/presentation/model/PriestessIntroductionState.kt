package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Priestess

data class PriestessIntroductionState(
    val priestess: Priestess? = null,
    val priestessIntroductionOption: PriestessIntroductionOption,
    val isClickable: Boolean = true,
    val isSelected: Boolean = false,
)