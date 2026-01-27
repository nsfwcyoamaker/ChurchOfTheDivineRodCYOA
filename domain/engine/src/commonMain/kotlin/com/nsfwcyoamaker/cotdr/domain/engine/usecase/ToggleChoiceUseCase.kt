package com.nsfwcyoamaker.cotdr.domain.engine.usecase

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.ChoiceState

class ToggleChoiceUseCase(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(choice: Choice) {
        gameStateManager.updateChoice<Choice, ChoiceState>(choice) { currentState ->
            if (currentState == null) {
                choice.getDefaultState()
            } else {
                null
            }
        }
    }
}