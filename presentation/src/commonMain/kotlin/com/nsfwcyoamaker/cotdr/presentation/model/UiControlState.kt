package com.nsfwcyoamaker.cotdr.presentation.model

import org.jetbrains.compose.resources.StringResource

sealed interface UiControlState {
    data object None : UiControlState

    data class MultiBuy(
        val count: Int,
        val max: Int?,
        val canBuyMore: Boolean,
        val totalFervor: Int,
    ) : UiControlState

    data class Upgrade(
        val text: StringResource,
        val isEnabled: Boolean,
        val isSelected: Boolean,
        val fervor: Int,
    ) : UiControlState
}