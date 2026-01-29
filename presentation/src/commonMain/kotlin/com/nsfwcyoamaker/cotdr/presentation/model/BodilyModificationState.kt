package com.nsfwcyoamaker.cotdr.presentation.model

data class BodilyModificationState(
    override val option: BodilyModificationOption,
    override val isSelected: Boolean = false,
    override val isEnabled: Boolean = true,
    val control: UiControlState = UiControlState.None,
): UiItemState