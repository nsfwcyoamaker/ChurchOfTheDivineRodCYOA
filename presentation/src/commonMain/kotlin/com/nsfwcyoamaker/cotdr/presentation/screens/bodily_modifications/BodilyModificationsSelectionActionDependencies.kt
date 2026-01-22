package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.domain.usecase.*
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class BodilyModificationsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getCurrentChoicesFlowUseCase: GetCurrentChoicesFlowUseCase,
    val bodilyModificationClickedUseCase: BodilyModificationClickedUseCase,
    val upgradeBodilyModificationClickedUseCase: UpgradeBodilyModificationClickedUseCase,
    val increaseBodilyModificationBuyTimesUseCase: IncreaseBodilyModificationBuyTimesUseCase,
    val decreaseBodilyModificationBuyTimesUseCase: DecreaseBodilyModificationBuyTimesUseCase,
): ActionDependencies()