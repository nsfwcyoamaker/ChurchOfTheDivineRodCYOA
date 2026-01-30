package com.nsfwcyoamaker.cotdr.presentation.model

data class ContractConductState(
    override val option: ContractConductOption,
    val contractState: ContractState = ContractState(option.parentContractOption),
    val conducts: List<ConductState> = option.conducts.map(::ConductState),
): UiItemState {
    data class ConductState(
        val conductOption: ContractConductOption.Conduct,
        val isSelected: Boolean = false,
    )
    override val isEnabled: Boolean
        get() = true
    override val isSelected: Boolean
        get() = true
}