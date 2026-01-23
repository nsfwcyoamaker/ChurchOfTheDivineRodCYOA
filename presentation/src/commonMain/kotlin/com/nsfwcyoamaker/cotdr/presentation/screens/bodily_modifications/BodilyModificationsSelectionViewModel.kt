package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.*
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.ObserveBodilyModificationsSelectionStateAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope

class BodilyModificationsSelectionViewModel(
    private val scope: CoroutineScope,
    private val getCurrentChoicesFlowUseCase: GetCurrentChoicesFlowUseCase,
    private val toggleChoiceUseCase: ToggleChoiceUseCase,
    private val toggleChoiceUpgradeUseCase: ToggleChoiceUpgradeUseCase,
    private val increaseChoiceBuyTimesUseCase: IncreaseChoiceBuyTimesUseCase,
    private val decreaseChoiceBuyTimesUseCase: DecreaseChoiceBuyTimesUseCase,
): ToadViewModel<BodilyModificationsSelectionState, Nothing>(
    initialState = BodilyModificationsSelectionState(),
    scope = scope,
) {
    override val dependencies = BodilyModificationsSelectionActionDependencies(
        scope,
        getCurrentChoicesFlowUseCase,
        toggleChoiceUseCase,
        toggleChoiceUpgradeUseCase,
        increaseChoiceBuyTimesUseCase,
        decreaseChoiceBuyTimesUseCase,
    )

    init {
        dispatch(ObserveBodilyModificationsSelectionStateAction)
    }

    fun runAction(action: BodilyModificationsSelectionAction) {
        dispatch(action)
    }
}