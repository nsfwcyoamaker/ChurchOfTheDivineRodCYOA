package com.nsfwcyoamaker.cotdr.domain.engine.logic

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository

class GameStateManager(
    private val repository: GameStateRepository,
    private val validator: GameStateValidator,
) {
    fun updateChoice(
        choice: Choice,
        transform: (ChoiceState) -> ChoiceState?
    ) {
        val currentMap = repository.selectedChoicesStateFlow.value.toMutableMap()
        val currentState = currentMap[choice] ?: ChoiceState.Empty

        val newState = transform(currentState)
        
        if (newState == null || (!newState.isSelected && newState.quantity == 0)) {
            currentMap.remove(choice)
        } else {
            currentMap[choice] = newState
        }

        val cleanMap = validator.sanitize(currentMap)

        repository.setSelectedChoices(cleanMap)
    }
}