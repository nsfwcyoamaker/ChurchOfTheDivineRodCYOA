package com.nsfwcyoamaker.cotdr.presentation.model

data class ChurchAppealState(
    override val option: ChurchAppealOption,
    override val isSelected: Boolean = false,
): UiItemState {
    override val isEnabled: Boolean
        get() = true
}