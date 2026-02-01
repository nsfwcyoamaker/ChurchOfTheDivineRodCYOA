package com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal

import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.action.ObserveChurchAppealAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ChurchAppealSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<ChurchAppealSelectionState, Nothing>(
    initialState = ChurchAppealSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<ChurchAppealSelectionActionDependencies> { parametersOf(scope) }

    init {
        dispatch(ObserveChurchAppealAction)
    }

    fun runAction(action: ChurchAppealSelectionAction) {
        dispatch(action)
    }
}