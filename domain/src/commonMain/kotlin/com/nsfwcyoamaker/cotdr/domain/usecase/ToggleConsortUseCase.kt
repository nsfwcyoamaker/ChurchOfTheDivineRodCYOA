package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository

class ToggleConsortUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(priestess: Priestess) {
        return repository.toggleConsort(priestess)
    }
}