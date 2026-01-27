package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetComputedChoicesUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(targetChoices: List<Choice>): Flow<List<ComputedChoice>> {
        return repository.selectedChoicesStateFlow.map { selections ->
            val context = CalculationContext(selections)
            targetChoices.map { choice ->
                choice.getComputedChoice(context)
            }
        }
    }
}