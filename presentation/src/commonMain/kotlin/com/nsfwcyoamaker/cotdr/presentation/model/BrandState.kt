package com.nsfwcyoamaker.cotdr.presentation.model

data class BrandState(
    override val option: BrandOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
): UiItemState {
    override val control: UiControlState
        get() = UiControlState.None
}