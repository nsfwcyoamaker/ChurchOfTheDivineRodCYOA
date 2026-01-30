package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.ConductType
import com.nsfwcyoamaker.cotdr.domain.model.ContractConduct

data class ContractConductOption(
    override val choice: ContractConduct,
    val parentContractOption: ContractOption,
) : UiOption {
    val conductMapping: Map<ContractConduct.Option, ServantConductOption> =
        choice.alternatives.associateWith { domainOption ->
            when (domainOption.type) {
                ConductType.Unrestrained -> ServantConductOption.Unrestrained
                ConductType.Aligned -> ServantConductOption.Aligned
                ConductType.Subjugated -> ServantConductOption.Subjugated
            }
        }
    val availableConducts: List<ServantConductOption> = ServantConductOption.entries

    companion object {
        val all = ContractOption.entries.associateBy { it.choice }.let { contractMap ->
            ContractConduct.all.mapNotNull { conduct ->
                contractMap[conduct.targetContract]?.let { contractOption ->
                    ContractConductOption(
                        choice = conduct,
                        parentContractOption = contractOption,
                    )
                }
            }
        }
    }
}