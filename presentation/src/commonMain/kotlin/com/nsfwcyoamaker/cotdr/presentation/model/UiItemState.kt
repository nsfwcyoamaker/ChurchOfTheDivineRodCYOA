package com.nsfwcyoamaker.cotdr.presentation.model

sealed interface UiItemState {
    val option: UiOption
    val isSelected: Boolean
    val isEnabled: Boolean
    val control: UiControlState
}