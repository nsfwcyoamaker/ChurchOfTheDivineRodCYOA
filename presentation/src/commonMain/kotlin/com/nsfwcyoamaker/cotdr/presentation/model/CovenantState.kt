package com.nsfwcyoamaker.cotdr.presentation.model

data class CovenantState(
    override val option: CovenantOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
): UiItemState {
    override val control: UiControlState
        get() = UiControlState.None
}