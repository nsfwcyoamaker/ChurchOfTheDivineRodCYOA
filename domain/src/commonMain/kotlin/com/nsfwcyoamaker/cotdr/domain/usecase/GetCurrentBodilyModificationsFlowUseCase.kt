package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCurrentBodilyModificationsFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Set<BodilyModification>> {
        return repository.selectedChoicesStateFlow
            .map { selections ->
                selections.keys.filterIsInstance<BodilyModification>().toSet()
            }
    }
}