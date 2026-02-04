package com.nsfwcyoamaker.cotdr.presentation.screens.rulings

import com.nsfwcyoamaker.cotdr.presentation.screens.rulings.action.ObserveRulingsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class RulingsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<RulingsSelectionState, Nothing>(
    initialState = RulingsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<RulingsSelectionActionDependencies> { parametersOf(scope) }

    init {
        dispatch(ObserveRulingsAction)
    }

    fun runAction(action: RulingsSelectionAction) {
        dispatch(action)
    }
}