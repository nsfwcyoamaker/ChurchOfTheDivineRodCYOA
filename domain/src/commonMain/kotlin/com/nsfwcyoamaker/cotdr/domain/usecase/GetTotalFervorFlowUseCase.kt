package com.nsfwcyoamaker.cotdr.domain.usecase

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.domain.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.domain.repository.GameStateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTotalFervorFlowUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(): Flow<Int> {
        return repository.selectedChoicesStateFlow
            .map { selections ->
                val context = CalculationContext(selections)
                var totalPoints = 0

                totalPoints += selections
                    .filterKeys { it is Priestess }
                    .count()
                    .let { amount -> ((amount*(amount-1))/2) * -1 }

                BodilyModification.entries.forEach { mod ->
                    val state = selections[mod] ?: ChoiceState.Empty

                    val isAvailable = mod.requirements(context)

                    if (isAvailable) {
                        val cost = mod.strategy.calculateCost(state, context)
                        totalPoints += cost
                    }
                }

                totalPoints
            }
    }
}