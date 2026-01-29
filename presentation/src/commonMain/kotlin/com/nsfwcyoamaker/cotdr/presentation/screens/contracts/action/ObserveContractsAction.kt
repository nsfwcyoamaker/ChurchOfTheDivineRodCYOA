package com.nsfwcyoamaker.cotdr.presentation.screens.contracts.action

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

object ObserveContractsAction: ContractsSelectionAction {
    override suspend fun execute(
        dependencies: ContractsSelectionActionDependencies,
        scope: ActionScope<ContractsSelectionState, Nothing>
    ) {
        UiChoiceMapper.mapStateFor(
            items = Contract.entries,
            options = ContractOption.entries,
            getComputedChoicesUseCase = dependencies.getComputedChoicesUseCase,
            makeState = { computed, option ->
                val computedAlternative = computed as? ComputedChoice.Alternative

                val alternatives = option.alternatives.map { alternative ->
                    ContractState.AlternativeState(
                        contractAlternative = alternative,
                        isSelected = alternative.originalAlternative == computedAlternative?.state?.selected
                    )
                }

                ContractState(
                    option = option,
                    isEnabled = alternatives.any { it.isSelected },
                    alternatives = alternatives
                )
            }
        ).collect { items ->
            scope.setState { ContractsSelectionState(items = items.associateBy { it.option }) }
        }
    }
}