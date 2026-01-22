package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.Choice
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentChoicesFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Map<Choice, ChoiceState>> {
        return repository.selectedChoicesStateFlow
    }
}