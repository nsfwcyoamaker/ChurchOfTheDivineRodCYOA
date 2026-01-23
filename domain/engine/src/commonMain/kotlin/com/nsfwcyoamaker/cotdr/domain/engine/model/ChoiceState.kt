package com.nsfwcyoamaker.cotdr.domain.engine.model

data class ChoiceState(
    val isSelected: Boolean = false,
    val quantity: Int = 1,
    val upgraded: Boolean = false,
) {
    companion object {
        val Empty = ChoiceState(isSelected = false, quantity = 0)
    }
}