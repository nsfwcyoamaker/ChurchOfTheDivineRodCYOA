package com.nsfwcyoamaker.cotdr.domain.engine.model

sealed interface ChoiceState {
    data object Selected: ChoiceState
    data class MultiBuy(val quantity: Int = 1): ChoiceState
    data class Upgradable(val upgraded: Boolean = false): ChoiceState
    data class Alternative(val selected: AlternativeChoice.Alternative): ChoiceState
}