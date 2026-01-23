package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState

class ToggleChoiceUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: Choice) {
        gameStateManager.updateChoice(choice) { currentState ->
            if (currentState.isSelected) {
                null
            } else {
                ChoiceState(isSelected = true, quantity = 1)
            }
        }
    }
}