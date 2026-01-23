package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.model.ComputedChoice
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import com.nsfwcyoamaker.cotdr.domain.engine.rules.CostStrategy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetComputedChoicesUseCase(
    private val repository: GameStateRepository,
) {
    operator fun invoke(targetChoices: List<Choice>): Flow<List<ComputedChoice>> {
        return repository.selectedChoicesStateFlow.map { selections ->
            val context = CalculationContext(selections)
            
            targetChoices.map { choice ->
                val state = selections[choice] ?: ChoiceState.Empty
                val reqMet = choice.requirements(context)

                val strategy = choice.strategy
                val maxQty = (strategy as? CostStrategy.MultiBuy)?.max
                val isUpgradable = strategy is CostStrategy.Upgradable
                val upgradeReqMet = if (isUpgradable) strategy.upgradeRequirements(context) else false

                ComputedChoice(
                    choice = choice,
                    state = state,
                    isAvailable = reqMet,
                    cost = strategy.calculateCost(state, context),
                    maxQuantity = maxQty,
                    isUpgradeAvailable = reqMet && upgradeReqMet,
                    isUpgradeSelected = state.upgraded
                )
            }
        }
    }
}