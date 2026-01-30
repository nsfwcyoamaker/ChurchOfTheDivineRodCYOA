package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalScoreRuleRegistry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CalculateTotalScoreUseCase(
    private val repository: GameStateRepository,
    private val choiceRegistry: ChoiceRegistry,
    private val ruleRegistry: GlobalScoreRuleRegistry
) {
    operator fun invoke(): Flow<Resources> {
        val allChoices = choiceRegistry.getAllChoices()
        val allRules = ruleRegistry.getScoreRules()

        return repository.selectedChoicesStateFlow
            .map { selections ->
                val context = CalculationContext(selections)
                var totalPoints = Resources.Empty

                allChoices.forEach { choice ->
                    totalPoints += choice.calculateCost(context)
                }

                allRules.forEach { rule ->
                    totalPoints += rule.calculateScore(context)
                }

                totalPoints
            }
    }
}