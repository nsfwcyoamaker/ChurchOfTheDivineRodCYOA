package com.nsfwcyoamaker.cotdr.presentation.model

data class ContractState(
    override val option: ContractOption,
    override val isEnabled: Boolean = false,
    val contractLevels: List<ContractLevelState> = option.contractLevels.map(::ContractLevelState),
): UiItemState {
    data class ContractLevelState(
        val contractLevelOption: ContractOption.ContractLevel,
        val isSelected: Boolean = false,
    )
    override val isSelected: Boolean
        get() = contractLevels.any { it.isSelected }
}