package com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action

import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

class ToggleContractAction(
    val contract: Contract,
): ContractConductsSelectionAction {
    override suspend fun execute(
        dependencies: ContractConductsSelectionActionDependencies,
        scope: ActionScope<ContractConductsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(contract)
    }
}