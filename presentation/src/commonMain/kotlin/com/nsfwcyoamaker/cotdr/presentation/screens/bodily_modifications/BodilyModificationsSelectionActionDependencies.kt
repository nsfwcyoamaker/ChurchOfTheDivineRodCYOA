package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.*
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class BodilyModificationsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
    val toggleChoiceUpgradeUseCase: ToggleChoiceUpgradeUseCase,
    val increaseChoiceBuyTimesUseCase: IncreaseChoiceBuyTimesUseCase,
    val decreaseChoiceBuyTimesUseCase: DecreaseChoiceBuyTimesUseCase,
): ActionDependencies()