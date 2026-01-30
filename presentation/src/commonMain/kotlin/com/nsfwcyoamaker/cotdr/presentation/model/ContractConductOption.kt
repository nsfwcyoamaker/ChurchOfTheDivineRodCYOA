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

    val conducts: List<Conduct> = listOf(
        Unrestrained(this),
        Aligned(this),
        Subjugated(this),
    )

    interface Conduct {
        val contractConductOption: ContractConductOption
        val originalConduct: ContractConduct.Option
        val ui: ServantConductOption
    }

    data class Unrestrained(
        override val contractConductOption: ContractConductOption,
    ): Conduct {
        override val originalConduct: ContractConduct.Option
            get() = ContractConduct.Option(
                choice = contractConductOption.choice,
                type = ConductType.Unrestrained
            )
        override val ui: ServantConductOption
            get() = ServantConductOption.Unrestrained
    }

    data class Aligned(
        override val contractConductOption: ContractConductOption,
    ): Conduct {
        override val originalConduct: ContractConduct.Option
            get() = ContractConduct.Option(
                choice = contractConductOption.choice,
                type = ConductType.Aligned
            )
        override val ui: ServantConductOption
            get() = ServantConductOption.Aligned
    }

    data class Subjugated(
        override val contractConductOption: ContractConductOption,
    ): Conduct {
        override val originalConduct: ContractConduct.Option
            get() = ContractConduct.Option(
                choice = contractConductOption.choice,
                type = ConductType.Subjugated
            )
        override val ui: ServantConductOption
            get() = ServantConductOption.Subjugated
    }

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