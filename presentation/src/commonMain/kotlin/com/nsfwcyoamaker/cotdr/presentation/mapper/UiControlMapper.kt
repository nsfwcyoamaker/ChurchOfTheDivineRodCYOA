package com.nsfwcyoamaker.cotdr.presentation.mapper

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy
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
            !computed.state.isSelected -> UiControlState.None

            computed.choice.strategy is CostStrategy.MultiBuy -> {
                UiControlState.MultiBuy(
                    count = computed.state.quantity,
                    max = computed.maxQuantity,
                    canBuyMore = computed.maxQuantity?.let { computed.state.quantity < it } ?: true
                )
            }

            computed.choice.strategy is CostStrategy.Upgradable -> {
                UiControlState.Upgrade(
                    text = upgradeText ?: Res.string.default_upgrade_text,
                    isEnabled = computed.isUpgradeAvailable,
                    isSelected = computed.isUpgradeSelected
                )
            }

            else -> UiControlState.None
        }
    }
}