package com.nsfwcyoamaker.cotdr.presentation.screens.covenants

import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.action.ObserveCovenantsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class CovenantsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<CovenantsSelectionState, Nothing>(
    initialState = CovenantsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<CovenantsSelectionActionDependencies> { parametersOf(scope) }

    init {
        dispatch(ObserveCovenantsAction)
    }

    fun runAction(action: CovenantsSelectionAction) {
        dispatch(action)
    }
}