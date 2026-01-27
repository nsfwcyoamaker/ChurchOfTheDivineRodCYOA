package com.nsfwcyoamaker.cotdr.domain.engine.logic

import com.nsfwcyoamaker.cotdr.domain.engine.model.CalculationContext
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository

class GameStateManager(
    private val repository: GameStateRepository,
    private val validator: GameStateValidator,
) {
    fun <C: Choice, S: ChoiceState> updateChoice(
        choice: C,
        transform: (S?) -> S?
    ) {
        val currentMap = repository.selectedChoicesStateFlow.value.toMutableMap()
        val ctx = CalculationContext(currentMap)
        val currentState = choice.getValidState(ctx) as? S

        val newState = transform(currentState)
        
        if (newState == null) {
            currentMap.remove(choice)
        } else {
            currentMap[choice] = newState
        }

        val cleanMap = validator.sanitize(currentMap)

        repository.setSelectedChoices(cleanMap)
    }
}