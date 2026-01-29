package com.nsfwcyoamaker.cotdr.presentation.model

data class ContractState(
    override val option: ContractOption,
    override val isEnabled: Boolean = false,
    val alternatives: List<AlternativeState> = option.alternatives.map(::AlternativeState),
): UiItemState {
    data class AlternativeState(
        val contractAlternative: ContractOption.Alternative,
        val isSelected: Boolean = false,
    )
    override val isSelected: Boolean
        get() = alternatives.any { it.isSelected }
}