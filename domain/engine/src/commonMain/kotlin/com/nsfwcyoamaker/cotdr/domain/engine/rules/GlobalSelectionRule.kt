package com.nsfwcyoamaker.cotdr.domain.engine.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState

fun interface GlobalSelectionRule {
    /**
     * Applies logic to [current] selections based on the [previous] state.
     * @param current The mutable map of selections currently being validated.
     * @param previous The state of selections BEFORE the user interaction started.
     * @return true if [current] was modified.
     */
    fun apply(
        current: MutableMap<Choice, ChoiceState>,
        previous: Map<Choice, ChoiceState>
    ): Boolean
}