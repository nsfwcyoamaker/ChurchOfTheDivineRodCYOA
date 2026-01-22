package com.nsfwcyoamaker.cotdr.presentation.model

import org.jetbrains.compose.resources.StringResource


sealed interface BodilyModificationExtraState {
    data object EmptyOption: BodilyModificationExtraState

    data class MultiBuyOption(
        val bodilyModificationOption: BodilyModificationOption,
        val boughtTimes: Int = 1,
        val maxBuyTimes: Int? = null,
        val canBuyMore: Boolean = true,
    ): BodilyModificationExtraState

    data class UpgradeOption(
        val bodilyModificationOption: BodilyModificationOption,
        val upgradeText: StringResource,
        val upgradeEnabled: Boolean = true,
        val upgradeSelected: Boolean = false,
    ): BodilyModificationExtraState
}