package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository

class ToggleConsortUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(priestess: Priestess) {
        val selected = repository.selectedChoicesStateFlow
            .value[priestess]
            ?.isSelected
            ?: false

        return repository.setChoiceState(priestess, ChoiceState(isSelected = true).takeIf { !selected })
    }
}