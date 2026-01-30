package com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action

import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ObserveContractStates
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveContractsAction: ContractsSelectionAction {
    override suspend fun execute(
        dependencies: ContractsSelectionActionDependencies,
        scope: ActionScope<ContractsSelectionState, Nothing>
    ) {
        ObserveContractStates(dependencies.getComputedChoicesUseCase).collect { items ->
            scope.setState { ContractsSelectionState(items = items.associateBy { it.option }) }
        }
    }
}