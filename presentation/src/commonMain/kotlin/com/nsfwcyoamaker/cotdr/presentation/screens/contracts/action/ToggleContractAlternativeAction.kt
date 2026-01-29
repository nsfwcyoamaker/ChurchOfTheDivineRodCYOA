package com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action

import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

class ToggleContractAlternativeAction(
    val contractAlternative: ContractOption.Alternative,
): ContractsSelectionAction {
    override suspend fun execute(
        dependencies: ContractsSelectionActionDependencies,
        scope: ActionScope<ContractsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceAlternativeUseCase(contractAlternative.originalAlternative)
    }
}