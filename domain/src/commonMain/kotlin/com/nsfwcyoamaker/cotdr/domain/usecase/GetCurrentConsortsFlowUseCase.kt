package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCurrentConsortsFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Set<Priestess>> {
        return repository.selectedChoicesStateFlow
            .map { selections ->
                selections.keys.filterIsInstance<Priestess>().toSet()
            }
    }
}