package com.nsfwcyoamaker.cotdr.presentation.model

data class BodilyModificationState(
    val option: BodilyModificationOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
    val control: UiControlState = UiControlState.None,
)