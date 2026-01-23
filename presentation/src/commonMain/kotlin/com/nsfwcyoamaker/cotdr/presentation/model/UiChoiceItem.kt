package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources

data class UiChoiceItem(
    val option: UiOption,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true,
    val costPreview: Resources = Resources.Empty,
    val control: UiControlState = UiControlState.None,
)