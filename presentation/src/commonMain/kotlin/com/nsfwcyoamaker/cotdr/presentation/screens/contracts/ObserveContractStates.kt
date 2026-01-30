package com.nsfwcyoamaker.cotdr.presentation.screens.contracts

import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.GetComputedChoicesUseCase
import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.presentation.mapper.UiChoiceMapper
import com.nsfwcyoamaker.cotdr.presentation.model.ContractOption
import com.nsfwcyoamaker.cotdr.presentation.model.ContractState
import kotlinx.coroutines.flow.Flow

object ObserveContractStates {
    operator fun invoke(getComputedChoicesUseCase: GetComputedChoicesUseCase): Flow<List<ContractState>> {
        return UiChoiceMapper.mapStateFor(
            items = Contract.entries,
            options = ContractOption.entries,
            getComputedChoicesUseCase = getComputedChoicesUseCase,
            makeState = { computed, option ->
                val computedAlternative = computed as? ComputedChoice.Alternative

                val contractLevels = option.contractLevels.map { contractLevelOption ->
                    ContractState.ContractLevelState(
                        contractLevelOption = contractLevelOption,
                        isSelected = contractLevelOption.originalContractLevel == computedAlternative?.state?.selected
                    )
                }

                ContractState(
                    option = option,
                    isEnabled = contractLevels.any { it.isSelected },
                    contractLevels = contractLevels
                )
            }
        )
    }
}