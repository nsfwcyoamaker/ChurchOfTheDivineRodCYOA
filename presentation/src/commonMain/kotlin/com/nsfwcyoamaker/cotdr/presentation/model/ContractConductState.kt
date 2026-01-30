package com.nsfwcyoamaker.cotdr.presentation.model

data class ContractConductState(
    override val option: ContractConductOption,
    val contractState: ContractState = ContractState(option.parentContractOption),
    val currentSelection: ServantConductOption = option.conductMapping[option.choice.alternatives.first()] ?: ServantConductOption.Unrestrained,
): UiItemState {
    override val isEnabled: Boolean
        get() = true
    override val isSelected: Boolean
        get() = true
}