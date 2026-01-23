package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCurrentBodilyModificationsFlowUseCase(
    private val repository: GameStateRepository,
    private val filterOnlyBodilyModificationsUseCase: FilterOnlyBodilyModificationsUseCase,
) {
    operator fun invoke(): Flow<Map<BodilyModification, ChoiceState>> {
        return repository.selectedChoicesStateFlow
            .map { selections -> filterOnlyBodilyModificationsUseCase(selections) }
    }
}