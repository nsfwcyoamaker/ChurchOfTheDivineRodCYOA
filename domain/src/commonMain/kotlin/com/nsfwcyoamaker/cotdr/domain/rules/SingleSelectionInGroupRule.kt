package com.nsfwcyoamaker.cotdr.domain.rules

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.rules.GlobalSelectionRule

class SingleSelectionInGroupRule(
    private val groupSelector: (Map<Choice, ChoiceState>) -> Set<Choice>,
): GlobalSelectionRule {
    override fun apply(
        current: MutableMap<Choice, ChoiceState>,
        previous: Map<Choice, ChoiceState>
    ): Boolean {
        val group = groupSelector(current)
        if (group.size <= 1) return false

        val previousGroup = groupSelector(previous)
        val new = group - previousGroup

        when(new.size) {
            0 -> group.drop(1).forEach(current::remove)
            1 -> previousGroup.forEach(current::remove)
            else -> {
                previousGroup.forEach(current::remove)
                new.drop(1).forEach(current::remove)
            }
        }

        return true
    }
}