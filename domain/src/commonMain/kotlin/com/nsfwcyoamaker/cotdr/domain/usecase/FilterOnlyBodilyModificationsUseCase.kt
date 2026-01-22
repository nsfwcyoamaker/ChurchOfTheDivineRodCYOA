package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.model.Choice
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState

class FilterOnlyBodilyModificationsUseCase {
    operator fun invoke(allChoices: Map<Choice, ChoiceState>): Map<BodilyModification, ChoiceState> {
        return allChoices.keys
            .filterIsInstance<BodilyModification>()
            .toSet()
            .mapNotNull { key ->
                allChoices[key]?.let { key to it }
            }
            .toMap()
    }
}