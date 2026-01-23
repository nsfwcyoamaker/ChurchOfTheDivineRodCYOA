package com.nsfwcyoamaker.cotdr.presentation.screens.covenants

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.*
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionDependencies
import kotlinx.coroutines.CoroutineScope

data class CovenantsSelectionActionDependencies(
    override val coroutineScope: CoroutineScope,
    val getComputedChoicesUseCase: GetComputedChoicesUseCase,
    val toggleChoiceUseCase: ToggleChoiceUseCase,
    val toggleChoiceUpgradeUseCase: ToggleChoiceUpgradeUseCase,
    val increaseChoiceBuyTimesUseCase: IncreaseChoiceBuyTimesUseCase,
    val decreaseChoiceBuyTimesUseCase: DecreaseChoiceBuyTimesUseCase,
): ActionDependencies()