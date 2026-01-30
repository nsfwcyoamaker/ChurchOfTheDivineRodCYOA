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
        val originalMap = repository.selectedChoicesStateFlow.value
        val workingMap = originalMap.toMutableMap()

        val ctx = CalculationContext(workingMap)
        val currentState = choice.getValidState(ctx) as? S
        val newState = transform(currentState)

        if (newState == null) {
            workingMap.remove(choice)
        } else {
            workingMap[choice] = newState
        }

        val cleanMap = validator.sanitize(workingMap, originalMap)

        repository.setSelectedChoices(cleanMap)
    }
}