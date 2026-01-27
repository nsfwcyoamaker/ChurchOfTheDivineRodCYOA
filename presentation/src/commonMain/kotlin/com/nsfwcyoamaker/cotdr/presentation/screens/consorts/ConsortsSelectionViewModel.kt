package com.nsfwcyoamaker.cotdr.presentation.screens.consorts

import com.nsfwcyoamaker.cotdr.domain.engine.usecase.ToggleChoiceUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.action.ObserveConsortsStateAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope

class ConsortsSelectionViewModel(
    private val scope: CoroutineScope,
    private val getCurrentConsortsFlowUseCase: GetCurrentConsortsFlowUseCase,
    private val toggleChoiceUseCase: ToggleChoiceUseCase,
): ToadViewModel<ConsortsSelectionState, Nothing>(
    initialState = ConsortsSelectionState(),
    scope = scope,
) {
    override val dependencies = ConsortsSelectionActionDependencies(
        scope,
        getCurrentConsortsFlowUseCase,
        toggleChoiceUseCase,
    )

    init {
        dispatch(ObserveConsortsStateAction)
    }

    fun runAction(action: ConsortsSelectionAction) {
        dispatch(action)
    }
}