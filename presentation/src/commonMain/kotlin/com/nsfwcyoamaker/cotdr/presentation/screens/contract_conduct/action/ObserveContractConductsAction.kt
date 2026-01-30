package com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.action

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractConductState
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionState
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ObserveContractStates
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

object ObserveContractConductsAction: ContractConductsSelectionAction {
    override suspend fun execute(
        dependencies: ContractConductsSelectionActionDependencies,
        scope: ActionScope<ContractConductsSelectionState, Nothing>
    ) {
        val contractStatesFlow: Flow<List<ContractState>> = ObserveContractStates(dependencies.getComputedChoicesUseCase)
        val computedConducts: Flow<List<ComputedChoice>> = dependencies.getComputedChoicesUseCase(ContractConduct.all)

        val conductUiOptions = ContractConductOption.all.associateBy { it.choice }

        val conductStatesFlow = combine(
            contractStatesFlow,
            computedConducts,
        ) { contractStates, computedConducts ->
            val contractStateMap = contractStates.associateBy { it.option.choice }

            computedConducts.mapNotNull { computed ->
                val domainChoice: ContractConduct = computed.choice as? ContractConduct
                    ?: return@mapNotNull null
                val option: ContractConductOption = conductUiOptions[domainChoice]
                    ?: return@mapNotNull null
                val parentState: ContractState = contractStateMap[domainChoice.targetContract]
                    ?.takeIf { it.isSelected }
                    ?: return@mapNotNull null

                val selectedAlternative = (computed as? ComputedChoice.Alternative)?.selected as? ContractConduct.Option

                val conducts = option.conducts.map { conductOption ->
                    ContractConductState.ConductState(
                        conductOption,
                        isSelected = conductOption.originalConduct == selectedAlternative
                    )
                }

                ContractConductState(
                    option = option,
                    contractState = parentState,
                    conducts = conducts,
                )
            }
        }

        conductStatesFlow.collect { items ->
            scope.setState { ContractConductsSelectionState(items = items) }
        }
    }
}