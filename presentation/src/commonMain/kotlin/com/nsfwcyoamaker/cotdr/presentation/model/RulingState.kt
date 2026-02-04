package com.nsfwcyoamaker.cotdr.presentation.model

data class RulingState(
    override val option: RulingOption,
    val rulingOptions: List<RulingOptionState> = option.alternatives.map(RulingState::RulingOptionState),
): UiItemState {
    override val isEnabled: Boolean
        get() = true
    override val isSelected: Boolean
        get() = false

    data class RulingOptionState(
        val rulingOption: RulingOption.Option,
        val isSelected: Boolean = false,
    )
}