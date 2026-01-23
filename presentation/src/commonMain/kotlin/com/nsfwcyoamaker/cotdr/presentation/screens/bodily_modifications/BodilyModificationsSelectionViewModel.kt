package com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications

import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.action.ObserveBodilyModificationsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class BodilyModificationsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<BodilyModificationsSelectionState, Nothing> (
    initialState = BodilyModificationsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<BodilyModificationsSelectionActionDependencies> { parametersOf (scope) }

    init { dispatch(ObserveBodilyModificationsAction) }

    fun runAction(action: BodilyModificationsSelectionAction) {
        dispatch(action)
    }
}