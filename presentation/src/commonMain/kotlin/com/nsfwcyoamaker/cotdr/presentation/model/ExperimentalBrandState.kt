package com.nsfwcyoamaker.cotdr.presentation.model

data class ExperimentalBrandState(
    override val option: ExperimentalBrandOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
): UiItemState {
    override val control: UiControlState
        get() = UiControlState.None
}