package com.nsfwcyoamaker.cotdr.presentation.model

data class ContractState(
    override val option: ContractOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
): UiItemState {
    override val control: UiControlState
        get() = UiControlState.None
}