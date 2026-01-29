package com.nsfwcyoamaker.cotdr.presentation.screens.contracts

import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action.ObserveContractsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ContractsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<ContractsSelectionState, Nothing> (
    initialState = ContractsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<ContractsSelectionActionDependencies> { parametersOf (scope) }

    init { dispatch(ObserveContractsAction) }

    fun runAction(action: ContractsSelectionAction) {
        dispatch(action)
    }
}