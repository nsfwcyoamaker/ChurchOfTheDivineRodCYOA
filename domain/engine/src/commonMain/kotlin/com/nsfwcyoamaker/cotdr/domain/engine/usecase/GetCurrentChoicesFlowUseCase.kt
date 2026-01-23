package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentChoicesFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Map<Choice, ChoiceState>> {
        return repository.selectedChoicesStateFlow
    }
}