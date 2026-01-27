package com.nsfwcyoamaker.cotdr.presentation.mapper

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.default_upgrade_text
import org.jetbrains.compose.resources.StringResource

object UiControlMapper {
    fun map(
        computed: ComputedChoice,
        upgradeText: StringResource? = null
    ): UiControlState {
        return when {
            computed.state == null || computed is ComputedChoice.Simple -> UiControlState.None
            computed is ComputedChoice.MultiBuy -> UiControlState.MultiBuy(
                count = computed.quantity,
                max = computed.maxQuantity,
                canBuyMore = computed.canBuyMore,
            )
            computed is ComputedChoice.Upgradable -> UiControlState.Upgrade(
                text = upgradeText ?: Res.string.default_upgrade_text,
                isEnabled = computed.isUpgradeAvailable,
                isSelected = computed.isUpgradeSelected,
            )
            else -> UiControlState.None
        }
    }
}