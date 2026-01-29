package com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action

import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

class ToggleContractAction(
    val contract: Contract,
): ContractsSelectionAction {
    override suspend fun execute(
        dependencies: ContractsSelectionActionDependencies,
        scope: ActionScope<ContractsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(contract)
    }
}