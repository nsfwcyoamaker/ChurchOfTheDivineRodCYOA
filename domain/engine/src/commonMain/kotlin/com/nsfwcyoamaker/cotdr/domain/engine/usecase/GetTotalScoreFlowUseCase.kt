package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalRuleRegistry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTotalScoreFlowUseCase(
    private val repository: GameStateRepository,
    private val choiceRegistry: ChoiceRegistry,
    private val ruleRegistry: GlobalRuleRegistry
) {
    operator fun invoke(): Flow<Int> {
        val allChoices = choiceRegistry.getAllChoices()
        val allRules = ruleRegistry.getRules()

        return repository.selectedChoicesStateFlow
            .map { selections ->
                val context = CalculationContext(selections)
                var totalPoints = 0

                allChoices.forEach { choice ->
                    val state = selections[choice] ?: ChoiceState.Empty
                    if (choice.requirements(context)) {
                        totalPoints += choice.strategy.calculateCost(state, context)
                    }
                }

                allRules.forEach { rule ->
                    totalPoints += rule.calculateScore(context)
                }

                totalPoints
            }
    }
}