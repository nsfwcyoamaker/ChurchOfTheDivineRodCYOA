package com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection

import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.ToggleConsortUseCase
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.action.ObserveRepoState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope

class ConsortsSelectionViewModel(
    private val scope: CoroutineScope,
    private val getCurrentConsortsFlowUseCase: GetCurrentConsortsFlowUseCase,
    private val toggleConsortUseCase: ToggleConsortUseCase,
): ToadViewModel<ConsortsSelectionState, Nothing>(
    initialState = ConsortsSelectionState(),
    scope = scope,
) {
    override val dependencies = ConsortsSelectionActionDependencies(
        scope,
        getCurrentConsortsFlowUseCase,
        toggleConsortUseCase,
    )

    init {
        dispatch(ObserveRepoState)
    }

    fun runAction(action: ConsortsSelectionAction) {
        dispatch(action)
    }
}