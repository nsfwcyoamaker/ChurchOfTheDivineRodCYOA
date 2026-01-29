package com.nsfwcyoamaker.cotdr.presentation.model

data class PriestessIntroductionState(
    override val option: PriestessIntroductionOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
): UiItemState