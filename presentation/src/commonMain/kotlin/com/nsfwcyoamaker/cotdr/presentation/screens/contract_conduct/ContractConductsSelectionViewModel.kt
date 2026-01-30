package com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct

import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action.ObserveContractConductsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ContractConductsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<ContractConductsSelectionState, Nothing> (
    initialState = ContractConductsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<ContractConductsSelectionActionDependencies> { parametersOf (scope) }

    init { dispatch(ObserveContractConductsAction) }

    fun runAction(action: ContractConductsSelectionAction) {
        dispatch(action)
    }
}