package com.nsfwcyoamaker.cotdr.presentation.mapper

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.model.CotdrCurrency.Fervor
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.presentation.model.UiOption

object UiControlMapper {
    fun map(
        computed: ComputedChoice,
        option: UiOption,
    ): UiControlState {
        return when {
            computed.state == null || computed is ComputedChoice.Simple -> UiControlState.None
            computed is ComputedChoice.MultiBuy -> UiControlState.MultiBuy(
                count = computed.quantity,
                max = computed.maxQuantity,
                canBuyMore = computed.canBuyMore,
                totalFervor = computed.totalCost[Fervor],
            )
            computed is ComputedChoice.Upgradable && option is UiOption.UpgradableUiOption -> UiControlState.Upgrade(
                text = option.upgradeText,
                isEnabled = computed.isUpgradeAvailable,
                isSelected = computed.isUpgradeSelected,
                fervor = option.choice.upgradeCost[Fervor],
            )
            else -> UiControlState.None
        }
    }
}